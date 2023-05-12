package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.TableModel;
import com.coffee.repository.TableRepository;

@Service
public class TableService {
	@Autowired
	TableRepository tableRepository;
	
	public List<TableModel> getAllTable() {
		return tableRepository.findAll();
	}
	
	public List<TableModel> getTableByIdLocation(int id){
		return tableRepository.getTableByIdLocation(id);
	}
	
	public boolean existsTableById(int idTable) {
		return tableRepository.existsById(idTable);
	}
}
