package com.foodbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String code;
 private String Category ;
 private String Description;
 private int price;
 private int quantity;
 private boolean is_active;
 @OneToOne
@JoinColumn(name = "Cuisine_id")
 private Cuisines cuisine;
public int getId() {
	return id;
}
public String getCode() {
	return code;
}
public String getCategory() {
	return Category;
}
public String getDescription() {
	return Description;
}
public int getPrice() {
	return price;
}
public int getQuantity() {
	return quantity;
}
public boolean isIs_active() {
	return is_active;
}
public Cuisines getCuisine() {
	return cuisine;
}
public void setId(int id) {
	this.id = id;
}
public void setCode(String code) {
	this.code = code;
}
public void setCategory(String category) {
	Category = category;
}
public void setDescription(String description) {
	Description = description;
}
public void setPrice(int price) {
	this.price = price;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public void setIs_active(boolean is_active) {
	this.is_active = is_active;
}
public void setCuisine(Cuisines cuisine) {
	this.cuisine = cuisine;
}
public Product(String code, String category, String description, int price, int quantity, boolean is_active,
		Cuisines cuisine) {
	super();
	this.code = code;
	Category = category;
	Description = description;
	this.price = price;
	this.quantity = quantity;
	this.is_active = is_active;
	this.cuisine = cuisine;
}
public Product() {
	
}
}
