package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffee.model.DetailBillModel;
import com.coffee.model.DisplayBillModel;

import jakarta.transaction.Transactional;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBillModel, Integer> {

	@Query("select d.quantity from DetailBillModel d where d.productId = ?1 and d.billId =?2")
	Integer exitsProductId(int productId, int billId);
	
	@Transactional
	@Modifying
	@Query("update DetailBillModel d set d.quantity = ?1 where d.billId = ?2 and d.productId = ?3")
	void updateQuantity(int quantity, int billId, int productId);
	
	
}
