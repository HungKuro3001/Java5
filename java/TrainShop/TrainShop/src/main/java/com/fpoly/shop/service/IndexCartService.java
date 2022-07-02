package com.fpoly.shop.service;

import java.util.List;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Train;


public interface IndexCartService{
	
	List<CartIndex> getIndexCartByCart(Cart cart);
	
	CartIndex getIndexCartByCartAndTrain(Train train,Cart cart);
	
	CartIndex saveIndexCart(CartIndex cartIndex);
	
	void deleteIndexCart(CartIndex cartIndex);
	
	void deleteAllChiMucGiohang(List<CartIndex> c);
	
}
