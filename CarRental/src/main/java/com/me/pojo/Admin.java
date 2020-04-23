package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="admin_info")
@Table(appliesTo = "admin_info")
public class Admin {
	
	public Admin() {}
	
	 @Id 
	 @GeneratedValue (strategy = GenerationType.AUTO)
	 private int Aid;
	
	@Column
	private String username;
	
	@Column
	private String pass;

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	

}
