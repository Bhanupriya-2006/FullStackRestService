package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@XmlRootElement
@Entity
@Table(name="usertableauto")
public class User implements Serializable{
	@Id
	@Column(name="userid" , length=5)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(name="username" , length=25)
	private String userName;
	@Column(name="password" ,length=25)
	private String password;

	public User() {
		super();

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
