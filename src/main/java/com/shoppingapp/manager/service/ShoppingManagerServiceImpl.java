package com.shoppingapp.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.CartDao;
import com.shoppingapp.dao.CategoryDao;
import com.shoppingapp.dao.ProductDao;
import com.shoppingapp.dao.ShpoppongDao;
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
	private CartDao cartDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ShpoppongDao shoppingDao;
	
	@Autowired
	private ProductDao productDao;

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
	public ProductDto addProductToCategory(ProductDto productDto, long idCategory) {
		Product product = orikaBeanMapper.map(productDto, Product.class);
		Category category = categoryDao.findById(idCategory).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addProductToCategory(product, category), ProductDto.class);
	}

	@Override
	public CategoryDto addShoppingToUser(ShoppingDto shoppingDto, long idUser) {
		Shopping shopping = orikaBeanMapper.map(shoppingDto, Shopping.class);
		User user = userDao.findById(idUser).orElse(null);
		return orikaBeanMapper.convertDTO(shoppingService.addShoppingToUser(shopping, user), CategoryDto.class);
	}

	@Override
	public List<CategoryDto> findCategoriesToShopping(long idShopping) {
		Shopping shopping = shoppingDao.findById(idShopping).orElse(null);
		List<Category> categories = shopping.getCategories();
		return orikaBeanMapper.convertListDTO(categories, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> findCategories() {
		List<Category> shoppings = categoryDao.findAll();
		return orikaBeanMapper.convertListDTO(shoppings, CategoryDto.class);
	}

	@Override
	public List<ProductDto> findProductsToCategory(long idCategory) {
		Category category = categoryDao.findById(idCategory).orElse(null);
       List<Product> products = category.getProducts();
		return orikaBeanMapper.convertListDTO(products, ProductDto.class);
	}

	@Override
	public List<ProductDto> findProducts() {
		List<Product> products = productDao.findAll();
		return orikaBeanMapper.convertListDTO(products, ProductDto.class);
	}


}
