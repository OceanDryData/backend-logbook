
package com.domain.interfaces.rest;

import com.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

public interface IRestCRUD<T, R> {


    ResponseEntity create(String JsonEntity);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    ResponseEntity read(@PathVariable("id") R id);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    ResponseEntity readAll();

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    ResponseEntity update(String JsonEntity);

    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    ResponseEntity delete(R id);

}