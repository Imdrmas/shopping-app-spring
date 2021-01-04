package com.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.CategoryDto;
import com.shoppingapp.dto.ProductDto;
import com.shoppingapp.dto.ShoppingDto;
import com.shoppingapp.manager.service.ShoppingManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ShoppingController {

	@Autowired
	private ShoppingManagerService shoppingManagerService;
	
	@PostMapping("/addShoppingToUser/{idUser}")
	CategoryDto addShoppingToUser(@RequestBody ShoppingDto shoppingDto, @PathVariable long idUser) {
		return shoppingManagerService.addShoppingToUser(shoppingDto, idUser);
	}

	@PostMapping("/addCategoryToShopping/{idShopping}")
	CategoryDto addCategoryToShopping(@RequestBody CategoryDto categoryDto, @PathVariable long idShopping) {
		return shoppingManagerService.addCategoryToShopping(categoryDto, idShopping);
	}

	@PostMapping("/addCartToUser/{idUser}")
	CartDto addCartToUser(@RequestBody CartDto cartDto, @PathVariable long idUser) {
		return shoppingManagerService.addCartToUser(cartDto, idUser);
	}
	
	@PostMapping("/addProductToCategory/{idCategory}")
	ProductDto addProductToCategory(@RequestBody ProductDto productDto, @PathVariable long idCategory) {
		return shoppingManagerService.addProductToCategory(productDto, idCategory);
	}
	
	@GetMapping("/findCategoriesToShopping/{idShopping}")
	List<CategoryDto> findCategoriesToShopping(@PathVariable long idShopping) {
		return shoppingManagerService.findCategoriesToShopping(idShopping);
	}
	
	@GetMapping("/findCategories")
	List<CategoryDto> findCategories() {
		return shoppingManagerService.findCategories();
	}

	@GetMapping("/findProductsToCategory/{idCategory}")
	List<ProductDto> findProductsToCategory(@PathVariable long idCategory) {
		return shoppingManagerService.findProductsToCategory(idCategory);
	}
	
	@GetMapping("/findProducts")
	List<ProductDto> findProducts() {
		return shoppingManagerService.findProducts();
	}
}
