package com.coffee.model;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "BillModel")
@Table(name = "Bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BillId", columnDefinition = "int")
	private Integer billId;

	@Column(name = "DateIn", columnDefinition = "datetime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateIn;

	@Column(name = "DateOut", columnDefinition = "datetime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateOut;

	@Column(name = "BillStatus", columnDefinition = "nvarchar(50)")
	private String billStatus;

	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "TableId",insertable=false, updatable=false)
	private TableModel table;

//	@JsonIgnore
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private Collection<DetailBillModel> detailBills;

	@JoinColumn(name = "TableId")
	private int tableId;
}
