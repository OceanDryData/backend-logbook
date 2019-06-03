package com.rest.controllers;

import com.domain.interfaces.rest.controllers.IBoatController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.domain.interfaces.logic.handlers.IUserHandler;
import com.domain.interfaces.rest.IRestCRUD;
import com.domain.models.Log;
import com.domain.models.User;
import com.google.gson.Gson;
import com.logic.handlers.LogHandler;
import com.persistence.repositories.IBoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

import static org.aspectj.lang.reflect.DeclareAnnotation.Kind.Type;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Log")

public class LogController implements IBoatController {

    private LogHandler handler;

    Gson gson = new Gson();

    public LogController() {
    }

    @Autowired
    public LogController(LogHandler handler) {
        this.handler = handler;
    }


    @Override
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody String JsonEntity) {
        Log log = gson.fromJson(JsonEntity, Log.class);
        Log result = handler.create(log);
        return new ResponseEntity<>(result,HttpStatus.valueOf(200));
    }
//
//    @Override
//    public ResponseEntity create(String JsonEntity) {
//        return null;
//    }

    @Override
    public ResponseEntity read(Long id) {
        Log result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }



    @Override
    public ResponseEntity readAll() {
        List<Log> boats = handler.readAll();
        List<Log> tmplog = new ArrayList<>();
        for (Log log : boats) {
            tmplog.add(log);
        }
        return new ResponseEntity<>(tmplog,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(String JsonEntity) {
        Log log = handler.update(gson.fromJson(JsonEntity,Log.class));
        return new ResponseEntity<>(log, HttpStatus.valueOf(200));
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