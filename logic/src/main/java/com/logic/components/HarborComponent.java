package com.logic.components;

import com.persistence.services.HarborService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HarborComponent {

    @Setter
    private HarborService service;

    public HarborComponent() {
    }

    @Autowired
    public HarborComponent(HarborService service) {
        this.service = service;
    }

}
