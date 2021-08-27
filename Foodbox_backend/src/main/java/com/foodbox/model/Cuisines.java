package com.foodbox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity 
public class Cuisines {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;

private String description;



public String getName() {
	return name;
}

public String getDescription() {
	return description;
}

public void setName(String name) {
	this.name = name;
}

public void setDescription(String description) {
	this.description = description;
}

public Cuisines(String name, String description) {
	super();
	this.name = name;
	this.description = description;
}
public Cuisines() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
}
