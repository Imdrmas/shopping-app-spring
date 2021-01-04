package com.shoppingapp.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.UserDao;
import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.ShoppingDto;
import com.shoppingapp.dto.UserDto;
import com.shoppingapp.modal.Cart;
import com.shoppingapp.modal.Shopping;
import com.shoppingapp.modal.User;
import com.shoppingapp.service.UserService;

@Transactional
@Service
public class UserManagerServiceImpl implements UserManagerService {
	
	@Autowired
	private OrikaBeanMapper orikaBeanMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = orikaBeanMapper.map(userDto, User.class);
		return orikaBeanMapper.convertDTO(userService.addUser(user), UserDto.class);
	}

	@Override
	public UserDto editUser(UserDto userDto, long idUser) {
		User user = orikaBeanMapper.map(userDto, User.class);
		User existsUser = userDao.findById(idUser).orElse(null);
		return orikaBeanMapper.convertDTO(userService.editUser(user, existsUser), UserDto.class);
	}

	@Override
	public void deleteUser(long idUser) {
      userDao.deleteById(idUser);	
	}

	@Override
	public List<CartDto> findCartsToUser(long idUser) {
		User existsUser = userDao.findById(idUser).orElse(null);
		List<Cart> carts = existsUser.getCarts();
		return orikaBeanMapper.convertListDTO(carts, CartDto.class);
	}


	@Override
	public UserDto findUserById(long idUser) {
		return orikaBeanMapper.convertDTO(userDao.findById(idUser).orElse(null), UserDto.class);
	}

	@Override
	public UserDto findUserByName(String username) {
	      Optional<User> user = userDao.findByUsername(username);
	        if (user.isPresent()) {
	            User user1 = user.get();
	            return orikaBeanMapper.convertDTO(user1, UserDto.class);
	        }
	        return null;

	}

	@Override
	public List<ShoppingDto> findShoppingsToUser(long idUser) {
		User existsUser = userDao.findById(idUser).orElse(null);
		List<Shopping> shoppings = existsUser.getShoppings();
		return orikaBeanMapper.convertListDTO(shoppings, ShoppingDto.class);
	}


}
