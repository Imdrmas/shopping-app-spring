package com.shoppingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.dao.UserDao;
import com.shoppingapp.modal.User;

@Transactional
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			user.setAdmin(true);
			return userDao.save(user);
		} else {
			return userDao.save(user);
		}

	}

	@Override
	public User editUser(User user, User existsUser) {
		existsUser.setUsername(user.getUsername());
		existsUser.setPassword(user.getPassword());
		existsUser.setAdmin(user.isAdmin());
		return userDao.save(existsUser);
	}

}
