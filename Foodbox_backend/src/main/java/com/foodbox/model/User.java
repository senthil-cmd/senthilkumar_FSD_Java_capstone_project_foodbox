package com.foodbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ;
private String firstname;
private String lastname;
private String role;
private String password;
private String email;
private int contact_number;
public int getId() {
	return id;
}
public String getFirstname() {
	return firstname;
}
public String getLastname() {
	return lastname;
}
public String getRole() {
	return role;
}
public String getPassword() {
	return password;
}
public String getEmail() {
	return email;
}
public int getContact_number() {
	return contact_number;
}
public void setId(int id) {
	this.id = id;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public void setRole(String role) {
	this.role = role;
}
public void setPassword(String password) {
	this.password = password;
}
public void setEmail(String email) {
	this.email = email;
}
public void setContact_number(int contact_number) {
	this.contact_number = contact_number;
}
public User(String firstname, String lastname, String role, String password, String email, int contact_number) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.role = role;
	this.password = password;
	this.email = email;
	this.contact_number = contact_number;
}
public User() {
	
}
}
