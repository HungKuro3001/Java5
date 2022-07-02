package com.fpoly.shop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fpoly.shop.entities.Manufacturer;


public interface ManufacturerService {

	List<Manufacturer> getALlHangSX();
	
	Page<Manufacturer> getAllManufacters(int page, int size);

	Manufacturer getManufacturerById(long id);

	Manufacturer save(Manufacturer h);

	Manufacturer update(Manufacturer h);

	void deleteById(long id);
}
