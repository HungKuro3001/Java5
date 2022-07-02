package com.fpoly.shop.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fpoly.shop.dto.SearchOrderObject;
import com.fpoly.shop.entities.Order;
import com.fpoly.shop.entities.User;



public interface OrderService {

	Page<Order> getAllOrderByFilter(SearchOrderObject object, int page) throws ParseException;

	Order update(Order order);
	
	Order findById(long id);
	


	Order save(Order order);
//	
	List<Object> getOrderByDateYear();



	
	List<Order> getOrderByNguoiDung(User currentUser);
	
	int countByStatusOrder(String statusOrder);
}
