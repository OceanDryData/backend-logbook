package com.domain.interfaces.rest.controllers;
        import com.fasterxml.jackson.databind.node.ObjectNode;
        import com.domain.interfaces.rest.IRestCRUD;
        import com.domain.models.Log;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import com.domain.models.User;

public interface ILogController extends IRestCRUD<Log, Long> {
    @RequestMapping(value = "/byBoat", method = RequestMethod.GET,consumes = "application/json")
    ResponseEntity readByUser(String user);
}
