package com.rest.controllers;

import com.domain.interfaces.rest.controllers.IBoatController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.domain.interfaces.logic.handlers.IUserHandler;
import com.domain.interfaces.rest.IRestCRUD;
import com.domain.models.Harbor;
import com.domain.models.User;
import com.google.gson.Gson;
import com.logic.handlers.HarborHandler;
import com.persistence.repositories.IHarborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Harbor")

public class HarborController implements IBoatController {

    private HarborHandler handler;

    Gson gson = new Gson();

    public HarborController() {
    }

    @Autowired
    public HarborController(HarborHandler handler) {
        this.handler = handler;
    }


    @Override
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody String JsonEntity) {
        Harbor harbor = gson.fromJson(JsonEntity, Harbor.class);
        Harbor result = handler.create(harbor);
        return new ResponseEntity<>(result,HttpStatus.valueOf(200));
    }
//
//    @Override
//    public ResponseEntity create(String JsonEntity) {
//        return null;
//    }

    @Override
    public ResponseEntity read(Long id) {
        Harbor result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }



    @Override
    public ResponseEntity readAll() {
        List<Harbor> harbors = handler.readAll();
        List<Harbor> tmpharbor = new ArrayList<>();
        for (Harbor harbor : harbors) {
            tmpharbor.add(harbor);
        }
        return new ResponseEntity<>(tmpharbor,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(String JsonEntity) {
        Harbor harbor = handler.update(gson.fromJson(JsonEntity,Harbor.class));
        return new ResponseEntity<>(harbor, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }

    @Override
    public ResponseEntity readByUser(String user) {
        return null;
    }
    
}