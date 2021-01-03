package com.shoppingapp.manager.service;

import org.springframework.stereotype.Service;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.CategoryDto;
import com.shoppingapp.dto.ProductDto;
import com.shoppingapp.dto.ShoppingDto;

@Service
public interface ShoppingManagerService {

	ShoppingDto addShoppingToUser(ShoppingDto shoppingDto, long idUser);
	 
	CategoryDto addCategoryToShopping(CategoryDto categoryDto, long idShopping);
	
	CartDto addCartToUser(CartDto cartDto, long idUser);
	
	ProductDto addProductToCart(ProductDto productDto, long idCart);
	
	ProductDto addProductToCategory(ProductDto productDto, long idCategory);
}
