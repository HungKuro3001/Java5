package com.fpoly.asm.service;

import java.text.ParseException;

import org.springframework.data.domain.Page;

import com.fpoly.asm.dto.SearchLienHeObject;
import com.fpoly.asm.entities.LienHe;

public interface LienHeService {

	Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException;

	LienHe findById(long id);
	
	LienHe save(LienHe lh);
	
	int countByTrangThai(String trangThai);

}
