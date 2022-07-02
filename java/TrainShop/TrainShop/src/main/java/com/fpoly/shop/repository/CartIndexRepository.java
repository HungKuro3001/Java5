package com.fpoly.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Train;

public interface CartIndexRepository extends JpaRepository<CartIndex, Long>{
	
	CartIndex findByTrainAndCart(Train train,Cart cart);
	
	List<CartIndex> findByCart(Cart cart);
}
