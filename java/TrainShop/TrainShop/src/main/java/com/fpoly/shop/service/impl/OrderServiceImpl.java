package com.fpoly.shop.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.QOrder;
import com.fpoly.shop.dto.SearchOrderObject;
import com.fpoly.shop.entities.Order;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.repository.OrderRepository;
import com.fpoly.shop.service.OrderService;
import com.querydsl.core.BooleanBuilder;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Page<Order> getAllOrderByFilter(SearchOrderObject object, int page) throws ParseException {
		BooleanBuilder builder = new BooleanBuilder();

		String statusOrder = object.getStatus();
		String startDate = object.getStartDate();
		String endDate = object.getEndDate();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

		if (!statusOrder.equals("")) {
			builder.and(QOrder.order.status.eq(statusOrder));
		}

		if (!startDate.equals("") && startDate != null) {
			if (statusOrder.equals("") || statusOrder.equals("Đang chờ giao") || statusOrder.equals("Đã hủy")) {
				builder.and(QOrder.order.dateOrder.goe(formatDate.parse(startDate)));
			} else if (statusOrder.equals("Đang giao")) {
				builder.and(QOrder.order.dateShip.goe(formatDate.parse(endDate)));
			} else { // hoàn thành
				builder.and(QOrder.order.dateReceipt.goe(formatDate.parse(startDate)));
			}
		}

		if (!endDate.equals("") && endDate != null) {
			if (statusOrder.equals("") || statusOrder.equals("Đang chờ giao") || statusOrder.equals("Đã hủy")) {
				builder.and(QOrder.order.dateOrder.loe(formatDate.parse(endDate)));
			} else if (statusOrder.equals("Đang giao")) {
				builder.and(QOrder.order.dateShip.loe(formatDate.parse(endDate)));
			} else { // hoàn thành
				builder.and(QOrder.order.dateReceipt.loe(formatDate.parse(endDate)));
			}
		}

		return orderRepository.findAll(builder, PageRequest.of(page - 1, 6));
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order findById(long id) {
		return orderRepository.findById(id).get();
	}



	@Override
	public Order save(Order dh) {
		return orderRepository.save(dh);
	}

	@Override
	public List<Object> getOrderByDateYear() {
		return orderRepository.OrderDateByYear();
	}
	
	@Override
	public List<Order> getOrderByNguoiDung(User user) {
		return orderRepository.findByNguoiDat(user);
	}



	@Override
	public int countByStatusOrder(String status) {
		return orderRepository.countStatusOrder(status);
	}

}
