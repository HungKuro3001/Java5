package com.fpoly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.GioHang;
import com.fpoly.shop.entities.NguoiDung;

public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	GioHang findByNguoiDung(NguoiDung n);
	
}
