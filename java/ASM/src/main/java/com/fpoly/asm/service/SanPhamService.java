package com.fpoly.asm.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.fpoly.asm.dto.SanPhamDto;
import com.fpoly.asm.dto.SearchSanPhamObject;
import com.fpoly.asm.entities.SanPham;

public interface SanPhamService {
	
 List<SanPham> getLatestSanPham();
	SanPham save(SanPhamDto sp);

	SanPham update(SanPhamDto sp);

	void deleteById(long id);

	Page<SanPham> getAllSanPhamByFilter(SearchSanPhamObject object, int page, int limit);

	SanPham getSanPhamById(long id);
	
	Iterable<SanPham> getSanPhamByTenSanPhamWithoutPaginate(SearchSanPhamObject object);
	
	Page<SanPham> getSanPhamByTenSanPham(SearchSanPhamObject object,int page, int resultPerPage);
	
	List<SanPham> getAllSanPhamByList(Set<Long> idList);
	
	Page<SanPham> getSanPhamByTenSanPhamForAdmin(String tenSanPham, int page, int size);
	
	Iterable<SanPham> getSanPhamByTenDanhMuc(String brand);
	
	public Page<SanPham> getSanPhamByBrand(SearchSanPhamObject object, int page, int resultPerPage);
}
