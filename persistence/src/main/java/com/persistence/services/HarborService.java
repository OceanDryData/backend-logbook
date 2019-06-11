package com.persistence.services;

import com.domain.models.Boat;
import com.domain.interfaces.ICRUD;
import com.domain.models.Harbor;
import com.domain.models.User;
import com.persistence.repositories.IHarborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarborService implements ICRUD<Harbor, Long> {

    @Qualifier("HarborRepository")
    @Autowired
    private IHarborRepository repository;


    @Override
    public Harbor create(Harbor entity) {
        return repository.save(entity);
    }

    @Override
    public Harbor read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Harbor> readAll() {
        return repository.findAll();
    }

    @Override
    public Harbor update(Harbor entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
    public List<Harbor> readByUser(User user){ return null;}
}
