package com.fpoly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.OrderDetail;
import com.fpoly.shop.repository.OrderDetailRepository;
import com.fpoly.shop.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public List<OrderDetail> save(List<OrderDetail> list)
	{	
		return orderDetailRepository.saveAll(list);
	}
}
