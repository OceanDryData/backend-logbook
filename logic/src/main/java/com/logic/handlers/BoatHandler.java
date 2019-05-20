package com.logic.handlers;

import com.domain.interfaces.logic.IHandlerCRUD;
import com.domain.models.Boat;
import com.logic.components.BoatComponent;
import com.persistence.services.BoatService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoatHandler implements IHandlerCRUD<Boat, Long> {

    @Setter
    private BoatComponent component;

    @Setter
    private BoatService service;

    public BoatHandler() {
    }

    @Autowired
    public BoatHandler(BoatComponent component, BoatService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Boat create(Boat entity) {
        return service.create(entity);
    }

    @Override
    public Boat read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Boat> readAll() {
        Iterable<Boat> boats = service.readAll();
        List<Boat> boatlist = new ArrayList<>();

        boats.iterator().forEachRemaining(boatlist::add);
        return boatlist;
    }

    @Override
    public Boat update(Boat entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
