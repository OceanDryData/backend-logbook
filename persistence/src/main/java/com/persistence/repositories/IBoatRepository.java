package com.persistence.repositories;

import com.domain.models.Boat;
import com.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository("BoatRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "Boat")
public interface IBoatRepository extends PagingAndSortingRepository<Boat, Long> {

}
