package com.shoppingapp.service;

import org.springframework.stereotype.Service;
import com.shoppingapp.modal.Cart;
import com.shoppingapp.modal.Category;
import com.shoppingapp.modal.Product;
import com.shoppingapp.modal.Shopping;
import com.shoppingapp.modal.User;

@Service
public interface ShoppingService {
	
	Shopping addShoppingToUser(Shopping shopping, User user);
 
	Category addCategoryToShopping(Category category, Shopping shopping);
	
	Cart addCartToUser(Cart cart, User user);
	
	Product addProductToCategory(Product product, Category category);
	
}
