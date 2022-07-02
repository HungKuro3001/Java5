package com.poly.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.Data;
@Data
@Entity
@Table
public class Train {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id")
	    private Integer id;
	    @Column(name = "name")
	    @Nationalized
	    private String name;
	    
	    @Column(name="date")
	    private Date createdDate;
	    @Column(name="seatNumber")
	    private int seatNumber	;
	   
	    @Column(name="carriageNumber")
	    private int carriageNumber;
	  
	    @Column(name="type")
	    private TrainType type;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
	
		public int getCarriageNumber() {
			return carriageNumber;
		}
		public void setCarriageNumber(int carriageNumber) {
			this.carriageNumber = carriageNumber;
		}
	
		public TrainType getType() {
			return type;
		}
		public void setType(TrainType type) {
			this.type = type;
		}
	    
	    
}
