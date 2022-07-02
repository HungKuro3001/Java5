package com.fpoly.asm.service;

import java.util.List;

import com.fpoly.asm.entities.VaiTro;

public interface VaiTroService {

	VaiTro findByTenVaiTro(String tenVaiTro);
	List<VaiTro> findAllVaiTro();
}
