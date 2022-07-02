package com.fpoly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.Category;
import com.fpoly.shop.repository.CategoryRepository;
import com.fpoly.shop.repository.OrderRepository;
import com.fpoly.shop.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Category d) {
		return categoryRepository.save(d);
	}

	@Override
	public void deleteById(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Page<Category> getAllCategoryForPageable(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Category getCategoryById(long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

}
