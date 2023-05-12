package com.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coffee.model.BillModel;
import com.coffee.model.DetailBillModel;
import com.coffee.model.DisplayBillModel;

import jakarta.transaction.Transactional;

@Repository
public interface BillRepository extends JpaRepository<BillModel, Integer> {
	
	@Transactional
	@Modifying
	@Query("insert into BillModel b(b.dateIn, b.dateOut, b.billStatus, b.tableId) values (?1, ?2, ?3, ?4)")	
	void insertBillToTable(java.util.Date dateIn, java.util.Date dateOut, String status, int idTable);
	
	@Query("select b.billStatus from BillModel b where b.billStatus = ?1 and b.tableId = ?2 group by b.billStatus")
	String isTableUnpaid(String status, int idTable);
	
	@Query("select b.billId from BillModel b where b.billStatus = ?1 and b.tableId = ?2")
	Integer getBillIdByStatusAndTableId(String status, int idTable);
	
	@Query("select b from BillModel b where b.table.tableId = ?1 and b.billStatus='unpaid'")
	BillModel getBillByTableId(int idTable);
	
	
}
