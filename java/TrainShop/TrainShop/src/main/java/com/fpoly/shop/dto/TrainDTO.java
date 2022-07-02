package com.fpoly.shop.dto;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fpoly.shop.entities.TrainType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainDTO {

	private Long id;

	private String name;
	private BigDecimal price;
    private Date createdDate;
    private int seatNumber	;
    private int quantity;
    private int carriageNumber;
    private Double length;
    private TrainType type;

	private long idCategory;
	private long idManufacturer;
	
	private MultipartFile hinhAnh;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(int carriageNumber) {
		this.carriageNumber = carriageNumber;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public TrainType getType() {
		return type;
	}

	public void setType(TrainType type) {
		this.type = type;
	}

	public long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public long getIdManufacturer() {
		return idManufacturer;
	}

	public void setIdManufacturer(long idManufacturer) {
		this.idManufacturer = idManufacturer;
	}

	public MultipartFile getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(MultipartFile hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	


	
}
