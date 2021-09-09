package tn.consomtounsi.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.consomtounsi.registration.entity.User;
import tn.consomtounsi.registration.service.RegistrationService;

@RestController
public class RegistrationController {
	/**
	 * save new user submit 
	 * but before we will check if the email exist or not
	 */
	@Autowired
	private RegistrationService service;
	
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		/**
		 * before saving user -- verify if email exist or not
		 */
		String tempEmailId =user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if (userobj !=null) {
				throw new Exception ("user with " +tempEmailId + "is already exist");
			}
		}
		
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	/**
	 * loginUser() 
	 * @param user
	 * @throws Exception 
	 */
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailId();
		String tempPass =user.getPassword();
		User userObj =null;
		if (tempEmailId !=null && tempPass !=null) {
			userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		//if this user 
		if(userObj == null) {
			throw new Exception("bad credentials");
		}
		return userObj;
	}
}
