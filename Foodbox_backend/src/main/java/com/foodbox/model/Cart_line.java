package com.foodbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Cart_line {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private int total;
@OneToOne
@JoinColumn(name = "product_id")
private Product product;
private int product_count;
private int buying_price;
public int getId() {
	return id;
}
public int getTotal() {
	return total;
}
public Product getProduct() {
	return product;
}
public int getProduct_count() {
	return product_count;
}
public int getBuying_price() {
	return buying_price;
}
public void setId(int id) {
	this.id = id;
}
public void setTotal(int total) {
	this.total = total;
}
public void setProduct(Product product) {
	this.product = product;
}
public void setProduct_count(int product_count) {
	this.product_count = product_count;
}
public void setBuying_price(int buying_price) {
	this.buying_price = buying_price;
}
public Cart_line(int total, Product product, int product_count, int buying_price) {
	super();
	this.total = total;
	this.product = product;
	this.product_count = product_count;
	this.buying_price = buying_price;
}
 public Cart_line() {
	 
 }
}
