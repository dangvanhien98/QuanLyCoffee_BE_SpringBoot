package com.coffee.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "ProductModel")
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId", columnDefinition = "int")
	private int productId;
	
	@Column(name = "ProductName", columnDefinition = "nvarchar(50)")
	private String productName;
	
	@Column(name = "Price", columnDefinition = "float")
	private float price;
	
	@Column(name = "Quantity", columnDefinition = "int")
	private int quantity;
	
	@Column(name = "Img", columnDefinition = "nvarchar(250)")
	private String img;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private CategoryModel category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<DetailBillModel> detailBills;
}
