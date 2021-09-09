package tn.consomtounsi.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.consomtounsi.registration.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);

}
