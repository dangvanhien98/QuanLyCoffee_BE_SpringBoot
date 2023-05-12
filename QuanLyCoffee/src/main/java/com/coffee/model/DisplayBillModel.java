package com.coffee.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DisplayBillModel")
public class DisplayBillModel {
	@Id
	private int id;
	private int billId;
	private Date dateIn;
	private Date dateOut;
	private int productId;
	private String img;
	private String productName;
	private Float price;
	private int quantity;
}
