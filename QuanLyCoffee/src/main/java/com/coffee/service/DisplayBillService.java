package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.DisplayBillModel;
import com.coffee.repository.DisplayBillRepository;

@Service
public class DisplayBillService {
	@Autowired DisplayBillRepository displayBillRepository;
	
}
