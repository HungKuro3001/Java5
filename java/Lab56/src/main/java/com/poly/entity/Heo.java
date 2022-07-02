package com.poly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
@Table
public class Heo {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Integer id;
	   @Column
	   @NotBlank
	   private String name;
	   @Column
	   private Date createDate;
	   @Column
	   private LoaiHeo type;
	   @Column
	   @NotNull
	   private Integer canNang;
	   @Column
	   @NotBlank
	   private String mauSac;
}
