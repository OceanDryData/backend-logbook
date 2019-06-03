package com.persistence.repositories;

import com.domain.models.Log;
import com.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository("LogRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "Log")
public interface ILogRepository extends PagingAndSortingRepository<Log, Long> {

}
