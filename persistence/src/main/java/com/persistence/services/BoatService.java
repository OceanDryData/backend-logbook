package com.persistence.services;

import com.domain.models.Boat;
import com.domain.interfaces.ICRUD;
import com.domain.models.Boat;
import com.persistence.repositories.IBoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoatService implements ICRUD<Boat, Long> {

    @Qualifier("BoatRepository")
    @Autowired
    private IBoatRepository repository;


    @Override
    public Boat create(Boat entity) {
        return repository.save(entity);
    }

    @Override
    public Boat read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Boat> readAll() {
        return repository.findAll();
    }

    @Override
    public Boat update(Boat entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
