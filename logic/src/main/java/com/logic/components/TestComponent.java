package com.logic.components;

import com.persistence.services.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {

    @Setter
    private TestService testService;

    @Autowired
    public TestComponent(TestService testService) {
        this.testService = testService;
    }
}
