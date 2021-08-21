package com.foodbox.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@OneToOne
	@JoinColumn(name = "User_id")
private User user;
private int total;
@OneToMany
@JoinColumn(name = "cartline")
private List<Cart_line> cartline;
public int getId() {
	return id;
}
public User getUser() {
	return user;
}
public int getTotal() {
	return total;
}
public List<Cart_line> getCartline() {
	return cartline;
}
public void setId(int id) {
	this.id = id;
}
public void setUser(User user) {
	this.user = user;
}
public void setTotal(int total) {
	this.total = total;
}
public void setCartline(List<Cart_line> cartline) {
	this.cartline = cartline;
}
public Cart(User user, int total, List<Cart_line> cartline) {
	super();
	this.user = user;
	this.total = total;
	this.cartline = cartline;
}


}
