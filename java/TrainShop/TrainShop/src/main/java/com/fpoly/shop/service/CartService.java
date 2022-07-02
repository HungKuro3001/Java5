package com.fpoly.shop.service;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.User;

public interface CartService {
	
	Cart getCartByUser(User user);
	
	Cart save(Cart cart);
}
