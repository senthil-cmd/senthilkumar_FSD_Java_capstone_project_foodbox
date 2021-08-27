package com.foodbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.Dao.CartDao;
import com.foodbox.model.Cart;

@RestController
@RequestMapping("api/cart")
public class CartRest {
@Autowired
CartDao cardao;

@GetMapping("/")
public List<Cart> getallcart() {
	return  (List<Cart>) cardao.findAll();
}
@PostMapping("/")
public Cart addcart(@RequestBody Cart cart) {
	cardao.save(cart);
	return cart;
}
@GetMapping("/{id}")
public Cart retrivecart(@PathVariable int id){
	Optional<Cart> cl = cardao.findById(id);
	if(cl.isPresent()) {
		
		Cart cartl  = cl.get();	
		return cartl ;
	}
	return null ;
}
@PutMapping("/")
public Cart updatecart(@RequestBody Cart  cart){
	Optional<Cart> cl = cardao.findById(cart.getId());
	if(cl.isPresent()) {
		
		cardao.save(cart);
		return cart;		
		
	}
	return null ;
}
@DeleteMapping("/{id}")
public boolean deleteproduct(@PathVariable int id) {
	Optional<Cart> cl = cardao.findById(id);
	if(cl.isPresent()) {
		cardao.deleteById(id);
		return true;
	}
	return false ;
}
}
