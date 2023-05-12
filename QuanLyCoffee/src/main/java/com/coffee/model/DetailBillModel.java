package com.coffee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "DetailBillModel")
@Table(name = "DetailBill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailBillModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DetailBillId", columnDefinition = "int")
	private int detailBillId;

	@ManyToOne
	@JoinColumn(name = "ProductId", insertable = false, updatable = false)
	private ProductModel product;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BillId", insertable = false, updatable = false)
	private BillModel bill;

	@Column(name = "Quantity", columnDefinition = "int")
	private int quantity;

	@JoinColumn(name = "BillId")
	private Integer billId;

	@JoinColumn(name = "ProductId")
	private int productId;
}
