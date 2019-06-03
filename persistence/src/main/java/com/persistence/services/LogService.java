package com.persistence.services;

import com.domain.models.Log;
import com.domain.interfaces.ICRUD;
import com.domain.models.User;
import com.persistence.repositories.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ICRUD<Log, Long> {

    @Qualifier("LogRepository")
    @Autowired
    private ILogRepository repository;


    @Override
    public Log create(Log entity) {
        return repository.save(entity);
    }

    @Override
    public Log read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Log> readAll() {
        return repository.findAll();
    }

    @Override
    public Log update(Log entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
    public List<Log> readByUser(User user){ return null;}
}
