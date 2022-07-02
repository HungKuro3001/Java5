package com.fpoly.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.asm.entities.ChiTietDonHang;
import com.fpoly.asm.repository.ChiMucGioHangRepository;
import com.fpoly.asm.repository.ChiTietDonHangRepository;
import com.fpoly.asm.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	
	@Autowired
	private ChiTietDonHangRepository repo;
	
	@Override
	public List<ChiTietDonHang> save(List<ChiTietDonHang> list)
	{	
		return repo.saveAll(list);
	}
}
