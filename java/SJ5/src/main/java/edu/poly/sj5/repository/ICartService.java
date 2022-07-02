package edu.poly.sj5.repository;

public interface ICartService {
	void addToCart(int productId, int quantity);
	void changeProductQuantity(int productId, int quantity);
	void removeProduct(int productId);
	void removeProducts();
}
