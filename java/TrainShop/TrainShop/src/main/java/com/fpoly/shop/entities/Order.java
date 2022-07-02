package com.fpoly.shop.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetail;

	private String address;
	private String sdt;
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date dateOrder;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date dateShip;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+7")
	private Date dateReceipt;

	private String status;
	private String description;

	@ManyToOne(optional = true)
	@JoinColumn(name = "idUser")
	private User nguoiDat;


	private BigDecimal totalPrice;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}


	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOrder() {
		return dateOrder;
	}


	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}


	public Date getDateShip() {
		return dateShip;
	}


	public void setDateShip(Date dateShip) {
		this.dateShip = dateShip;
	}


	public Date getDateReceipt() {
		return dateReceipt;
	}


	public void setDateReceipt(Date dateReceipt) {
		this.dateReceipt = dateReceipt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public User getNguoiDat() {
		return nguoiDat;
	}


	public void setNguoiDat(User nguoiDat) {
		this.nguoiDat = nguoiDat;
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Order() {
		super();
	}

	
	

}
