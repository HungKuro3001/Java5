package com.fpoly.shop.api.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.shop.entities.Category;
import com.fpoly.shop.entities.ResponseObject;
import com.fpoly.shop.service.CategoryService;

@RestController
@RequestMapping("api/danh-muc")
public class DanhMucApi {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public Page<Category> getAllDanhMuc(@RequestParam(defaultValue = "1") int page) {
		return categoryService.getAllCategoryForPageable(page-1,6);
	}
	
	@GetMapping("/allForReal")
	public List<Category> getRealAllDanhMuc() {
		return categoryService.getAllCategory();
	}

	@GetMapping("/{id}")
	public Category getDanhMucById(@PathVariable long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping(value = "/save")
	public ResponseObject addDanhMuc(@RequestBody @Valid Category newDanhMuc, BindingResult result, HttpServletRequest request) {
		
		ResponseObject ro = new ResponseObject();
		
		if (result.hasErrors()) {

			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			
			List<String> keys = new ArrayList<String>(errors.keySet());			
			for (String key: keys) {
			    System.out.println(key + ": " + errors.get(key));
			}
			
			ro.setStatus("fail");
			errors = null;
			;
		} else {
			categoryService.save(newDanhMuc);
			ro.setData(newDanhMuc);
			ro.setStatus("success");
		}
		return ro;
	}
	
	@PutMapping(value = "/update")
	public ResponseObject updateDanhMuc(@RequestBody @Valid Category editDanhMuc, BindingResult result, HttpServletRequest request) {
		
		ResponseObject ro = new ResponseObject();		
		if (result.hasErrors()) {

			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			ro.setStatus("fail");
			errors = null;
			
		} else {
			categoryService.update(editDanhMuc);
			ro.setData(editDanhMuc);
			ro.setStatus("success");
		}
		
		return ro;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDanhMuc(@PathVariable long id, HttpServletRequest request) {
		categoryService.deleteById(id);
		request.getSession().setAttribute("listDanhMuc", categoryService.getAllCategory());;
		return "OK !";
	}

}
