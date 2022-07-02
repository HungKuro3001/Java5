package com.fpoly.shop.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Manufacturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message="Tên hãng sản xuất không được trống")
	private String nameManufacturer;

	@JsonIgnore
	@OneToMany(mappedBy = "manufacturer")
	private List<Train> listTrain;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameManufacturer() {
		return nameManufacturer;
	}

	public void setNameManufacturer(String nameManufacturer) {
		this.nameManufacturer = nameManufacturer;
	}

	public List<Train> getListTrain() {
		return listTrain;
	}

	public void setListTrain(List<Train> listTrain) {
		this.listTrain = listTrain;
	}

	
}
