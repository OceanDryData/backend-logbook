package com.domain.interfaces.rest.controllers;
        import com.fasterxml.jackson.databind.node.ObjectNode;
        import com.domain.interfaces.rest.IRestCRUD;
        import com.domain.models.Boat;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import com.domain.models.User;

public interface IBoatController extends IRestCRUD<Boat, Long> {
    @RequestMapping(value = "/byUser", method = RequestMethod.GET)
    ResponseEntity readByUser(String user);
}
