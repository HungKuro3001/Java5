package com.fpoly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.shop.entities.Cart;
import com.fpoly.shop.entities.CartIndex;
import com.fpoly.shop.entities.Train;
import com.fpoly.shop.repository.CartIndexRepository;
import com.fpoly.shop.service.IndexCartService;

@Service
public class IndexCartServiceImpl implements IndexCartService{
	
	@Autowired
	private CartIndexRepository indexCartRepository;
	
	@Override
	public CartIndex getIndexCartByCartAndTrain(Train train,Cart cart)
	{
		return indexCartRepository.findByTrainAndCart(train,cart);
	}
	
	@Override
	public CartIndex saveIndexCart(CartIndex cartIndex)
	{
		return indexCartRepository.save(cartIndex);
	}
	
	@Override
	public void deleteIndexCart(CartIndex cartIndex)
	{
		indexCartRepository.delete(cartIndex);
	}
	
	@Override
	public List<CartIndex> getIndexCartByCart(Cart cart)
	{
		return indexCartRepository.findByCart(cart);
	}
	
	@Override
	public void deleteAllChiMucGiohang(List<CartIndex> cartIndex)
	{
		indexCartRepository.deleteAll(cartIndex);
	}

}
