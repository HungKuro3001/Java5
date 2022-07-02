package com.fpoly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.fpoly.shop.entities.Order;
import com.fpoly.shop.entities.User;


public interface OrderRepository extends JpaRepository<Order, Long>, QuerydslPredicateExecutor<Order> {

//	public List<Order> findByTrangThaiDonHangAndShipper(String trangThai, User shipper);
//
	@Query(value = "select DATE_FORMAT(dh.dateReceipt, '%m') as month, "
			+ " DATE_FORMAT(dh.dateReceipt, '%Y') as year, sum(ct.quantity * ct.price) as total "
			+ " from Order dh, OrderDetail ct"
			+ " where dh.id = ct.donHang.id and dh.status ='Hoàn thành'"
			+ " group by DATE_FORMAT(dh.dateReceipt, '%Y%m')"
			+ " order by year asc" )
	public List<Object> OrderDateByYear();
	
	public List<Order> findByNguoiDat(User user);
	
	public int countStatusOrder(String status);
	
}
