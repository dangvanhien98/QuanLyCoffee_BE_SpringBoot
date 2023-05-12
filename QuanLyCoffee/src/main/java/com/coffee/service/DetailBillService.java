package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.model.DetailBillModel;
import com.coffee.model.DisplayBillModel;
import com.coffee.repository.DetailBillRepository;

@Service
public class DetailBillService {

	@Autowired
	DetailBillRepository detailBillRepository;

	public void insertBillDetail(DetailBillModel deBillModel) {
		detailBillRepository.save(deBillModel);
	}

	public Integer exitsProductId(int productId, int billId) {
		return detailBillRepository.exitsProductId(productId, billId);
	}

	public void updateQuantity(int quantity, int billId, int productId) {
		detailBillRepository.updateQuantity(quantity, billId, productId);
	}
	
	
}
