package com.cg.ofd.login.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.login.dao.LoginRepository;
import com.cg.ofd.login.entities.Login;
import com.cg.ofd.login.exception.UserNotFoundException;
import com.cg.ofd.login.service.LoginService;

/**
 * @author Mugdha
 * 
 *         LoginController
 */

@RestController
@RibbonClient(name = "Login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	// This method is to view all the details of login
	@GetMapping("/login")
	public List<Login> retrieve() {
		List<Login> login = loginService.retrieve();
		if (login.isEmpty())
			throw new UserNotFoundException("User not found");
		else
			return login;
	}

	// This method is to find details by userID
	@GetMapping("/login/{userId}")
	public Login findUserbyId(@PathVariable int userId) {
		Login login = loginService.findUserbyId(userId); // .findById(userId).get();
		if (login == null)
			throw new UserNotFoundException("Details Not Found");
		else
			return login;
	}

	// This method is to find details by userName and Password i.e. for Login
	@GetMapping(path = "/login/{userName}/{password}")
	public Login findByuserName(@PathVariable String userName, @PathVariable String password) {
		Login tmpList = loginService.findByuserNameAndPassword(userName, password);
		if (tmpList == null)
			throw new UserNotFoundException("UserName and Password not found");
		else
			return tmpList;
	}

	// This method is to register OR SignUp the user
	@PostMapping(path = "/login/signup")
	public Login signUp(@Valid @RequestBody Login login) {
		if (login.getUserName() == null || login.getPassword() == null || login.getUserName().isEmpty()
				|| login.getPassword().isEmpty()) {
			throw new UserNotFoundException("Please fill details correctly");
		} else {
			Login signup = loginService.signUp(login);
			return signup;
		}
	}

	// This method is to update the details of user
	@PutMapping("/login/update")
	public void updateDetails(@RequestBody Login login) {
		logger.info("Inside updateDetails method of LoginController");
		loginService.updateDetails(login);
	}

	// This method is to return the role of user
	@GetMapping("/login/getrole/{userId}")
	public String currentRole(@PathVariable int userId) {
		System.out.println("Inside currentRole() ");
		Login login = loginService.findUserbyId(userId);
		String tmprole = login.getRole();
		return login.getRole();

	}
}
