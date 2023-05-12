package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.BillModel;
import com.coffee.model.DetailBillModel;
import com.coffee.model.DisplayBillModel;
import com.coffee.repository.BillRepository;

@Service
public class BillService{
	@Autowired
	BillRepository billRepository;
	
	public void insertBillToTable(BillModel bill, int idTable){
		billRepository.insertBillToTable(bill.getDateIn(), bill.getDateOut(), bill.getBillStatus(), idTable);
	}
	
	public String isTableUnpaid(String status, int idTable) {
		return billRepository.isTableUnpaid(status, idTable);
	}
	
	public Integer getBillIdByStatusAndTableId(String status, int idTable) {
		return billRepository.getBillIdByStatusAndTableId(status, idTable);
	}
	
	public BillModel getBillByTableId(int idTable){
		return billRepository.getBillByTableId(idTable);
	}
	
	
}
