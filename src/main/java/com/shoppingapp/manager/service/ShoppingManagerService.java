package com.shoppingapp.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.CategoryDto;
import com.shoppingapp.dto.ProductDto;
import com.shoppingapp.dto.ShoppingDto;

@Service
public interface ShoppingManagerService {
	 
	CategoryDto addCategoryToShopping(CategoryDto categoryDto, long idUser);
	
	CartDto addCartToUser(CartDto cartDto, long idUser);
	
	ProductDto addProductToCategory(ProductDto productDto, long idCategory);

	CategoryDto addShoppingToUser(ShoppingDto shoppingDto, long idUser);

	List<CategoryDto> findCategoriesToShopping(long idShopping);

	List<CategoryDto> findCategories();

	List<ProductDto> findProductsToCategory(long idCategory);

	List<ProductDto> findProducts();
}
