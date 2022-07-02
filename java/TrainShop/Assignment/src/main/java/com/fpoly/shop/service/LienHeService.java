package com.fpoly.shop.service;

import java.text.ParseException;

import org.springframework.data.domain.Page;

import com.fpoly.shop.dto.SearchLienHeObject;
import com.fpoly.shop.entities.LienHe;

public interface LienHeService {

	Page<LienHe> getLienHeByFilter(SearchLienHeObject object, int page) throws ParseException;

	LienHe findById(long id);
	
	LienHe save(LienHe lh);
	
	int countByTrangThai(String trangThai);

}
