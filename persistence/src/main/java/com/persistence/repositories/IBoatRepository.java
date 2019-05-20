package com.persistence.repositories;

import com.domain.models.Boat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("BoatRepository")
public interface IBoatRepository extends PagingAndSortingRepository<Boat, Long> {
}
