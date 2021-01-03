package com.shoppingapp.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.CartDao;
import com.shoppingapp.dao.CategoryDao;
import com.shoppingapp.dao.ShoppingDao;
import com.shoppingapp.dao.UserDao;
import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.CategoryDto;
import com.shoppingapp.dto.ProductDto;
import com.shoppingapp.dto.ShoppingDto;
import com.shoppingapp.modal.Cart;
import com.shoppingapp.modal.Category;
import com.shoppingapp.modal.Product;
import com.shoppingapp.modal.Shopping;
import com.shoppingapp.modal.User;
import com.shoppingapp.service.ShoppingService;

@Service
@Transactional
public class ShoppingManagerServiceImpl implements ShoppingManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ShoppingDao shoppingDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public ShoppingDto addShoppingToUser(ShoppingDto shoppingDto, long idUser) {
		Shopping shopping = orikaBeanMapper.map(shoppingDto, Shopping.class);
		User user = userDao.findById(idUser).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addShoppingToUser(shopping, user), ShoppingDto.class);
	}

	@Override
	public CategoryDto addCategoryToShopping(CategoryDto categoryDto, long idShopping) {
		Category category = orikaBeanMapper.map(categoryDto, Category.class);
		Shopping shopping = shoppingDao.findById(idShopping).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addCategoryToShopping(category, shopping), CategoryDto.class);
	}

	@Override
	public CartDto addCartToUser(CartDto cartDto, long idUser) {
		Cart cart = orikaBeanMapper.map(cartDto, Cart.class);
		User user = userDao.findById(idUser).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addCartToUser(cart, user), CartDto.class);
	}

	@Override
	public ProductDto addProductToCart(ProductDto productDto, long idCart) {
		Product product = orikaBeanMapper.map(productDto, Product.class);
		Cart cart = cartDao.findById(idCart).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addProductToCart(product, cart), ProductDto.class);
	}

	@Override
	public ProductDto addProductToCategory(ProductDto productDto, long idCategory) {
		Product product = orikaBeanMapper.map(productDto, Product.class);
		Category category = categoryDao.findById(null).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addProductToCategory(product, category), ProductDto.class);
	}

}
