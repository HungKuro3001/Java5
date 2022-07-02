package com.fpoly.shop.service;

import com.fpoly.shop.entities.GioHang;
import com.fpoly.shop.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
