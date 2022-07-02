package com.fpoly.shop.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchTrainObject {
	private String idCategory;
	private String idManufacturer;
	private String price;
	
	// sap xep theo gia
	private String soryByPrice;
	private String[] keyword;
	private String sort;
	
	// sap xep theo danhmuc va hangsx
	private String brand;
	private String manufactor;
	
	// theo ram, pin, kiểu dáng
	private String seatNumber;
	private String carrierNumber;
	private String length;

	public SearchTrainObject() {
		idCategory = "";
		idManufacturer = "";
		price = "";
		soryByPrice = "ASC";
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getIdManufacturer() {
		return idManufacturer;
	}

	public void setIdManufacturer(String idManufacturer) {
		this.idManufacturer = idManufacturer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSoryByPrice() {
		return soryByPrice;
	}

	public void setSoryByPrice(String soryByPrice) {
		this.soryByPrice = soryByPrice;
	}

	public String[] getKeyword() {
		return keyword;
	}

	public void setKeyword(String[] keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getCarrierNumber() {
		return carrierNumber;
	}

	public void setCarrierNumber(String carrierNumber) {
		this.carrierNumber = carrierNumber;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
}
