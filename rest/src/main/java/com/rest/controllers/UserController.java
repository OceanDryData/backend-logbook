package com.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.domain.interfaces.logic.handlers.IUserHandler;
import com.domain.interfaces.rest.controllers.IUserController;
import com.domain.models.User;
import com.logic.handlers.UserHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    private IUserHandler handler;

    Gson gson = new Gson();

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity login(@RequestBody ObjectNode node) {
        String email = node.get("email").asText();
        String password = node.get("password").asText();
        User user = handler.login(email,password);
        user = addDefaultLinks(user);
        return new ResponseEntity<>(user, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity create(@RequestBody String JsonEntity) {
        User result = handler.create(gson.fromJson(JsonEntity,User.class));
        result = addDefaultLinks(result);
        return new ResponseEntity<>(result,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(@RequestParam(name = "id", required = true)Long id) {
        User result = handler.read(id);
        if (result != null) {
            result = addDefaultLinks(result);
            return new ResponseEntity<User>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }

    @Override
    public ResponseEntity readAll() {
        List<User> users = handler.readAll();
        List<User> tmpUsers = new ArrayList<>();
        for (User user : users) {
            tmpUsers.add(addDefaultLinks(user));
        }
        return new ResponseEntity<>(tmpUsers,HttpStatus.valueOf(200));
    }

    public ResponseEntity update(@RequestBody String JsonEntity) {
        User user = handler.update(gson.fromJson(JsonEntity,User.class));

        user = addDefaultLinks(user);

        return new ResponseEntity<>(user, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(@RequestParam(name = "id", required = true)Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }

    @Override
    public User addDefaultLinks(User entity){

        //entity.add(linkTo(methodOn(UserController.class).create("")).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).read(1L)).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).readAll()).withSelfRel());
        //entity.add(linkTo(methodOn(UserController.class).update("")).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).delete(1L)).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).login(null)).withSelfRel());

        return entity;
    }
}
