package com.fpoly.asm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.asm.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
