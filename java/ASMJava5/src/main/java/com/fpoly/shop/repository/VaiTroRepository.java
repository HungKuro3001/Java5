package com.fpoly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
