package com.fpoly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
}
