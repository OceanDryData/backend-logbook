package com.persistence.repositories;

import com.domain.models.Harbor;
import com.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository("HarborRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "Harbor")
public interface IHarborRepository extends PagingAndSortingRepository<Harbor, Long> {

}
