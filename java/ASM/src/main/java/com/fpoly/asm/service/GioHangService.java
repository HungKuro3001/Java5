package com.fpoly.asm.service;

import com.fpoly.asm.entities.GioHang;
import com.fpoly.asm.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
