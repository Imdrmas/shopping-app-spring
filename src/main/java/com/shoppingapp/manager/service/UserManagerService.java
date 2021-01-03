package com.shoppingapp.manager.service;

import java.util.List;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.UserDto;
import com.shoppingapp.modal.Shopping;

public interface UserManagerService {

	UserDto addUser(UserDto userDto);
	
	UserDto editUser(UserDto userDto, long idUser);
	
	void deleteUser(long idUser);
	
	List<CartDto> findCartsToUser(long idUser);
	
	List<Shopping> findShoppingsToUser(long idUser);
	
	UserDto findUserById(long idUser);
}
