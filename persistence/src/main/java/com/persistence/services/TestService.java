package com.persistence.services;

import com.domain.interfaces.ICRUD;
import com.domain.models.Test;
import com.persistence.repositories.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ICRUD<Test,Long> {

    @Qualifier("TestRepository")
    @Autowired
    private ITestRepository iUserRepository;

    @Override
    public Long create(Test entity) {
        return null;
    }

    @Override
    public Test read(long id) {
        return null;
    }

    @Override
    public Iterable readAll() {
        return null;
    }

    @Override
    public Long update(Test entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
