package com.foodbox.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@OneToOne
@JoinColumn(name = "User_id")
private User user;
private String Address_1;
private String Address_2;
private String City;
private String State;
private String Country;
private String Postal_code;
public int getId() {
	return id;
}
public User getUser() {
	return user;
}
public String getAddress_1() {
	return Address_1;
}
public String getAddress_2() {
	return Address_2;
}
public String getCity() {
	return City;
}
public String getState() {
	return State;
}
public String getCountry() {
	return Country;
}
public String getPostal_code() {
	return Postal_code;
}
public void setId(int id) {
	this.id = id;
}
public void setUser(User user) {
	this.user = user;
}
public void setAddress_1(String address_1) {
	Address_1 = address_1;
}
public void setAddress_2(String address_2) {
	Address_2 = address_2;
}
public void setCity(String city) {
	City = city;
}
public void setState(String state) {
	State = state;
}
public void setCountry(String country) {
	Country = country;
}
public void setPostal_code(String postal_code) {
	Postal_code = postal_code;
}
public Address(User user, String address_1, String address_2, String city, String state, String country,
		String postal_code) {
	super();
	this.user = user;
	Address_1 = address_1;
	Address_2 = address_2;
	City = city;
	State = state;
	Country = country;
	Postal_code = postal_code;
}

}
