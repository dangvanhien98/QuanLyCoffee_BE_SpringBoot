package com.coffee.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TableModel")
@Table(name = "Tables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableModel {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TableId", columnDefinition = "int")
	private int tableId;
	
	@Column(name = "TableName", columnDefinition = "nvarchar(50)")
	private String tableName;
	
	@Column(name = "StatusTable", columnDefinition = "nvarchar(50)")
	private String statusTable;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LocationId")
	private LocationModel location;
	

	@OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
	private Collection<BillModel> bills;

	
//	@Transient
//	private int LocationId;
	
}
