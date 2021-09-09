package tn.consomtounsi.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.consomtounsi.registration.entity.User;
import tn.consomtounsi.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser (User user) {
		return repo.save(user);	
	}
	//find user by emailId
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	// find user by EmailId And Password
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email,password);
	}
}
