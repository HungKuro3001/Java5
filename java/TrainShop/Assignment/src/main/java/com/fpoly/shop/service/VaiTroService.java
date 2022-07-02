package com.fpoly.shop.service;

import java.util.List;

import com.fpoly.shop.entities.VaiTro;

public interface VaiTroService {

	VaiTro findByTenVaiTro(String tenVaiTro);
	List<VaiTro> findAllVaiTro();
}
