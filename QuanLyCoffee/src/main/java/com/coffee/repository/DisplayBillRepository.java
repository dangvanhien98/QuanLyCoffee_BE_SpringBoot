package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coffee.model.DisplayBillModel;

@Repository
public interface DisplayBillRepository extends CrudRepository<DisplayBillModel, Integer> {
	
}
