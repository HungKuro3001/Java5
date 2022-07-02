package com.fpoly.shop.service;

import java.util.List;

import com.fpoly.shop.entities.OrderDetail;


public interface OrderDetailService {
	List<OrderDetail> save(List<OrderDetail> list);
}
