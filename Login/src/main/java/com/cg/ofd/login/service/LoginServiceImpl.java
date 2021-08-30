package com.cg.ofd.login.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofd.login.dao.*;
import com.cg.ofd.login.entities.Login;

/**
 * @author Mugdha
 * 
 *         LoginService Implementation
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public List<Login> retrieve() {
		System.out.println("Inside retrieve() method");
		return loginRepository.findAll();
	}

	@Override
	public Login findByuserNameAndPassword(String userName, String password) {
		System.out.println("Inside findByuserNameAndPassword() method");
		Login tmpList = loginRepository.findByuserNameAndPassword(userName, password);
		return tmpList;
	}

	@Override
	public Login signUp(Login login) {
		System.out.println("Inside signUp() method");
		return this.loginRepository.save(login);
	}

	@Override
	public Login findUserbyId(int userId) {
		System.out.println("Inside findUserbyId() method");
		Login login = loginRepository.findById(userId).get();
		return login;
	}

	@Override
	public Login updateDetails(Login login) {
		System.out.println("Inside updateDetails() method");
		return loginRepository.save(login);
	}

}
