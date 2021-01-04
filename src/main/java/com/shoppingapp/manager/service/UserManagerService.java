package com.shoppingapp.manager.service;

import java.util.List;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.ShoppingDto;
import com.shoppingapp.dto.UserDto;

public interface UserManagerService {

	UserDto addUser(UserDto userDto);
	
	UserDto editUser(UserDto userDto, long idUser);
	
	void deleteUser(long idUser);
	
	List<CartDto> findCartsToUser(long idUser);
	
	List<ShoppingDto> findShoppingsToUser(long idUser);
	
	UserDto findUserById(long idUser);
	
	UserDto findUserByName(String username);

}
