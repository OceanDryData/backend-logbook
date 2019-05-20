package com.logic.components;

import com.persistence.services.BoatService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoatComponent {

    @Setter
    private BoatService service;

    public BoatComponent() {
    }

    @Autowired
    public BoatComponent(BoatService service) {
        this.service = service;
    }

}
