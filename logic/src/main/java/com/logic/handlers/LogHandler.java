package com.logic.handlers;

import com.domain.interfaces.logic.IHandlerCRUD;
import com.domain.models.Log;
import com.logic.components.LogComponent;
import com.persistence.services.LogService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogHandler implements IHandlerCRUD<Log, Long> {

    @Setter
    private LogComponent component;

    @Setter
    private LogService service;

    public LogHandler() {
    }

    @Autowired
    public LogHandler(LogComponent component, LogService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Log create(Log entity) {
        return service.create(entity);
    }

    @Override
    public Log read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Log> readAll() {
        Iterable<Log> logs = service.readAll();
        List<Log>loglist = new ArrayList<>();

        logs.iterator().forEachRemaining(loglist::add);
        return loglist;
    }

    @Override
    public Log update(Log entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
