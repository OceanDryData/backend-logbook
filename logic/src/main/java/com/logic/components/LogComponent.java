package com.logic.components;

import com.persistence.services.LogService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogComponent {

    @Setter
    private LogService service;

    public LogComponent() {
    }

    @Autowired
    public LogComponent(LogService service) {
        this.service = service;
    }

}
