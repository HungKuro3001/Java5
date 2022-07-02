package com.fpoly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.Manufacturer;
import com.fpoly.shop.repository.ManufacturerRepository;
import com.fpoly.shop.service.ManufacturerService;

@Service
public class ManuFacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> getALlHangSX() {
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer getManufacturerById(long id) {
		return manufacturerRepository.findById(id).get();
	}

	@Override
	public Manufacturer save(Manufacturer h) {
		return manufacturerRepository.save(h);
	}

	@Override
	public Manufacturer update(Manufacturer h) {
		return manufacturerRepository.save(h);
	}

	@Override
	public void deleteById(long id) {
		manufacturerRepository.deleteById(id);
	}

	@Override
	public Page<Manufacturer> getAllManufacters(int page, int size) {
		return manufacturerRepository.findAll(PageRequest.of(page, size));
	}

}
