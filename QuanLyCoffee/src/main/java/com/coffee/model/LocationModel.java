package com.coffee.model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "LocationModel")
@Table(name = "Location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LocationId", columnDefinition = "int")
	private int locationId;
	
	@Column(name = "LocationName", columnDefinition = "nvarchar(50)")
	private String locationName;
	
	
	@JsonIgnore // không cần lấy tables
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private Collection<TableModel> tables;
}
