package com.shoppingapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.CartDao;
import com.shoppingapp.dao.CategoryDao;
import com.shoppingapp.dao.ProductDao;
import com.shoppingapp.dao.ShoppingDao;
import com.shoppingapp.modal.Cart;
import com.shoppingapp.modal.Category;
import com.shoppingapp.modal.Product;
import com.shoppingapp.modal.Shopping;
import com.shoppingapp.modal.User;

@Transactional
@Component
public class ShoppingServiceImpl implements ShoppingService {
	
	@Autowired
	private ShoppingDao shoppingDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Shopping addShoppingToUser(Shopping shopping, User user) {
		user.addShoppingToUser(shopping);
		return shoppingDao.save(shopping);
	}

	@Override
	public Category addCategoryToShopping(Category category, Shopping shopping) {
		shopping.addCategoryToShopping(category);
		return categoryDao.save(category);
	}

	@Override
	public Cart addCartToUser(Cart cart, User user) {
		user.addCartToUser(cart);
		return cartDao.save(cart);
	}

	@Override
	public Product addProductToCart(Product product, Cart cart) {
		cart.addProductToCart(product);
		return productDao.save(product);
	}

	@Override
	public Product addProductToCategory(Product product, Category category) {
		category.addProductToCategory(product);
		return productDao.save(product);
	}

}
