package com.shoppingapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.CartDao;
import com.shoppingapp.dao.CategoryDao;
import com.shoppingapp.dao.ProductDao;
import com.shoppingapp.dao.ShpoppongDao;
import com.shoppingapp.modal.Cart;
import com.shoppingapp.modal.Category;
import com.shoppingapp.modal.Product;
import com.shoppingapp.modal.Shopping;
import com.shoppingapp.modal.User;

@Transactional
@Component
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ShpoppongDao shoppingDao;

	@Override
	public Category addCategoryToShopping(Category category, Shopping shopping) {  
		if (shopping.getCategories().size()==0) {
			category.setExpanded(true);
		} else {
			category.setExpanded(false);
		}
		shopping.addCategoryToShopping(category);
		return categoryDao.save(category);
	}

	@Override
	public Cart addCartToUser(Cart cart, User user) {
		cart.setAdded(new Date());
		user.addCartToUser(cart);
		return cartDao.save(cart);
	}


	@Override
	public Product addProductToCategory(Product product, Category category) {
		product.setCreated(new Date());
		category.addProductToCategory(product);
		return productDao.save(product);
	}

	@Override
	public Shopping addShoppingToUser(Shopping shopping, User user) {
		
		if (user.getShoppings().size()==0) {
			shopping.setExpanded(true);
		} else {
			shopping.setExpanded(false);
		}
		user.addShoppingToUser(shopping);
		return shoppingDao.save(shopping);
	}

}
