package com.fpoly.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.User;
import com.fpoly.shop.repository.CartRepository;
import com.fpoly.shop.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart getCartByUser(User user)
	{
		return cartRepository.findByUser(user);
	}
	
	@Override
	public Cart save(Cart g)
	{
		return cartRepository.save(g);
	}

}
