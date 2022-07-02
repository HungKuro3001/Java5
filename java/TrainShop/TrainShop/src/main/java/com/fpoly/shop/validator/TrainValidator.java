package com.fpoly.shop.validator;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fpoly.shop.dto.TrainDTO;
import com.fpoly.shop.service.CategoryService;

@Component
public class TrainValidator implements Validator{
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public boolean supports(Class<?> clazz) {
		return TrainDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TrainDTO s = (TrainDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "error.name", "Tên sản phẩm không được trống");
		ValidationUtils.rejectIfEmpty(errors, "price", "error.price", "Đơn giá không được trống");
		ValidationUtils.rejectIfEmpty(errors, "quantity", "error.quantity", "Số lượng không được trống");
	
		
		
		
		if(s.getPrice().compareTo(new BigDecimal(0)) > 0) {
			errors.rejectValue("price", "error.price", "Đơn giá không được âm");
		}
		
	
		String categoryName = categoryService.getCategoryById(s.getId()).getNameCategory().toLowerCase();
		
		if(categoryName.contains("Train".toLowerCase())) {
			ValidationUtils.rejectIfEmpty(errors, "carriageNumber", "error.carriageNumber","Số toa không được bỏ trống");
			ValidationUtils.rejectIfEmpty(errors, "seatNumber", "error.seatNumber", "Số ghế không được trống");
			ValidationUtils.rejectIfEmpty(errors, "length", "error.length", "Độ dài không được trống");
		}
		
	}

}
