package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.TableModel;
import com.coffee.service.TableService;

@CrossOrigin
@RestController
@RequestMapping("/table")
public class TableController {
	@Autowired
	TableService tableService;
	
	@GetMapping
	public ResponseEntity<?> getAllTable(){
		List<TableModel> tables = tableService.getAllTable();
		if(tables != null) return new ResponseEntity<List<TableModel>>(tables, HttpStatus.OK);
		return new ResponseEntity<String>("not found table in database", HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/findByLocationId/{id}")
	public ResponseEntity<?> getTableByIdLocation(@PathVariable int id){
		System.out.println("id"+id);
		List<TableModel> tablesByIdLocation = tableService.getTableByIdLocation(id);
		List<TableModel> tables = tableService.getAllTable();
		if(id == 0|| id == 1) {
			return new ResponseEntity<List<TableModel>>(tables, HttpStatus.OK);
		}
			
		if(tablesByIdLocation != null) return new ResponseEntity<List<TableModel>>(tablesByIdLocation, HttpStatus.OK);
		return new ResponseEntity<String>("not found table in database", HttpStatus.OK);
		
	}
}
