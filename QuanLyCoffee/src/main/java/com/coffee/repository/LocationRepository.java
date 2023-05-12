package com.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffee.model.LocationModel;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Integer>  {
//		LocationModel getById(Integer id);
}
