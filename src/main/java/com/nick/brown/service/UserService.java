package com.nick.brown.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nick.brown.entity.User;
import com.nick.brown.exception.ValidationException;
import com.nick.brown.repository.jpa.UserJPARepository;

@Service
public class UserService {

	@Autowired
	private UserJPARepository userJPA;
	
	public Page<User> findAll(Pageable pageable) {
		return userJPA.findAll(pageable/*, new Sort(Sort.Direction.ASC, "id")*/);
	}
	
	public User save(User user) throws ValidationException {
		if (user.getFirstName() == null || user.getFirstName().length() == 0) {
			throw new ValidationException("First Name Is Required.");
		}
		else if (user.getLastName() == null || user.getLastName().length() == 0) {
			throw new ValidationException("Last Name Is Required.");
		}
		else if (user.getZip() == null || (user.getZip().length() != 5 && user.getZip().length() != 9)) {
			throw new ValidationException("Zip Must Be 5 or 9 Digits.");
		}
		else if (user.getCountry() == null || !user.getCountry().equals("US")) {
			throw new ValidationException("Country Must Be US.");
		}
		else if (user.getState() == null || (user.getState().length() != 2)) {
			throw new ValidationException("State Must Be 2 Digits.");
		}
		user.setCreatedDate(new Date());
		return userJPA.save(user);
	}
}
