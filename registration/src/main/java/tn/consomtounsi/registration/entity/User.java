package tn.consomtounsi.registration.entity;

import java.io.Serializable;

import javax.persistence.*;
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String emailId;
	private String userNama;
	private String password;
	
	public User() {
		
	}
	
	
	public User(int id, String emailId, String userNama, String password) {
		
		this.emailId = emailId;
		this.userNama = userNama;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserNama() {
		return userNama;
	}
	public void setUserNama(String userNama) {
		this.userNama = userNama;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
