package com.shoppingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.dto.CartDto;
import com.shoppingapp.dto.ShoppingDto;
import com.shoppingapp.dto.UserDto;
import com.shoppingapp.manager.service.UserManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserManagerService userManagerService;
	
	
	@PostMapping("/addUser")
	UserDto addUser(@RequestBody UserDto userDto) {
		return userManagerService.addUser(userDto);
	}
	
	@PutMapping("/editUser/{idUSer}")
	UserDto editUser(@RequestBody UserDto userDto, @PathVariable long idUser) {
		return userManagerService.editUser(userDto, idUser);
	}
	
	@DeleteMapping("/deleteUser/{idUser}")
	void deleteUser(@PathVariable long idUser) {
		userManagerService.deleteUser(idUser);
	}
	
	@GetMapping("/findCartsToUser/{idUser}")
	List<CartDto> findCartsToUser(@PathVariable long idUser) {
		return userManagerService.findCartsToUser(idUser);
	}
	
	@GetMapping("/findUserById/{idUser}")
	UserDto findUserById(@PathVariable long idUser) {
		return userManagerService.findUserById(idUser);
	}
	
	@GetMapping("/findUserByUsername/{username}")
	UserDto findUserByUsername(@PathVariable String username) {		
        return userManagerService.findUserByName(username);
	}
	
	@GetMapping("/findShoppingToUser/{idUser}")
	List<ShoppingDto> findShoppingToUser(@PathVariable long idUser) {
		return userManagerService.findShoppingsToUser(idUser);
	}

}
