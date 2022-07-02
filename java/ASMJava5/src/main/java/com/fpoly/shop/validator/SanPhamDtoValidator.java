package com.fpoly.shop.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fpoly.shop.dto.SanPhamDto;
import com.fpoly.shop.service.DanhMucService;

@Component
public class SanPhamDtoValidator implements Validator{
	
	@Autowired
	private DanhMucService dmService;

	@Override
	public boolean supports(Class<?> clazz) {
		return SanPhamDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SanPhamDto s = (SanPhamDto) target;
		
		ValidationUtils.rejectIfEmpty(errors, "tenSanPham", "error.tenSanPham", "Tên sản phẩm không được trống");
		ValidationUtils.rejectIfEmpty(errors, "donGia", "error.donGia", "Đơn giá không được trống");
		ValidationUtils.rejectIfEmpty(errors, "donViKho", "error.donViKho", "Đơn vị kho không được trống");
		ValidationUtils.rejectIfEmpty(errors, "thongTinBaoHanh", "error.thongTinBaoHanh", "Thông tin bảo hành không được trống");
		ValidationUtils.rejectIfEmpty(errors, "thongTinChung", "error.thongTinChung", "Thông tin chung không được trống");
		
		if(Integer.parseInt(s.getDonGia()) < 0) {
			errors.rejectValue("donGia", "error.donGia", "Đơn giá không được âm");
		}
		
		if(Integer.parseInt(s.getDonViKho()) < 0) {
			errors.rejectValue("donViKho", "error.donViKho", "Đơn giá không được âm");
		}
		String tenDanhMuc = dmService.getDanhMucById(s.getDanhMucId()).getTenDanhMuc().toLowerCase();
		
		if(tenDanhMuc.contains("Car".toLowerCase())) {
			ValidationUtils.rejectIfEmpty(errors, "xuatSu", "error.xuatSu", "Xuất sứ không được trống");
			ValidationUtils.rejectIfEmpty(errors, "kieuDang", "error.kieuDang", "Kiểu dáng không được trống");
			ValidationUtils.rejectIfEmpty(errors, "hopSo", "error.hopSo", "Hộp số không được trống");
			ValidationUtils.rejectIfEmpty(errors, "soKM", "error.soKM", "Số KM không được trống");
			ValidationUtils.rejectIfEmpty(errors, "mauXe", "error.mauXe", "Màu xe không được trống");
			ValidationUtils.rejectIfEmpty(errors, "soChoNgoi", "error.soChoNgoi", "Số chỗ ngồi không được trống");			
		}
		
	}

}
