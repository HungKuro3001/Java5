package com.fpoly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.User;



public interface CartRepository extends JpaRepository<Cart, Long>{
	
	Cart findByUser(User user);
	
}
