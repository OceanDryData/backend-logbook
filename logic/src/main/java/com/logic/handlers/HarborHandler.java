package com.logic.handlers;

import com.domain.interfaces.logic.IHandlerCRUD;
import com.domain.models.Harbor;
import com.logic.components.HarborComponent;
import com.persistence.services.HarborService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HarborHandler implements IHandlerCRUD<Harbor, Long> {

    @Setter
    private HarborComponent component;

    @Setter
    private HarborService service;

    public HarborHandler() {
    }

    @Autowired
    public HarborHandler(HarborComponent component, HarborService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Harbor create(Harbor entity) {
        return service.create(entity);
    }

    @Override
    public Harbor read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Harbor> readAll() {
        Iterable<Harbor> harbors = service.readAll();
        List<Harbor> harborlist = new ArrayList<>();

        harbors.iterator().forEachRemaining(harborlist::add);
        return harborlist;
    }

    @Override
    public Harbor update(Harbor entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}
