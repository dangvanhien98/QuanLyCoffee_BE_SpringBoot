package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffee.model.TableModel;

@Repository
public interface TableRepository extends JpaRepository<TableModel, Integer>{

	@Query(value = "select u from TableModel u where u.location.locationId = ?1")
	List<TableModel> getTableByIdLocation(int id);
}
