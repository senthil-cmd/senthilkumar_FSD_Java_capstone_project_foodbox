package com.foodbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/")
public List<Cart> getallcart() {
	return  (List<Cart>) cardao.findAll();
}
@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/")
public Cart addcart(@RequestBody Cart cart) {
	cardao.save(cart);
	return cart;
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/{id}")
public Cart retrivecart(@PathVariable int id){
	Optional<Cart> cl = cardao.findById(id);
	if(cl.isPresent()) {
		
		Cart cartl  = cl.get();	
		return cartl ;
	}
	return null ;
}
//@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/")
public Cart updatecart(@RequestBody Cart cartd){
	Optional<Cart> cl = cardao.findById(cartd.getId());
	if(cl.isPresent()) {
		
		cardao.save(cartd);
		return cartd;		
		
	}
	return null ;
}
@CrossOrigin(origins = "http://localhost:4200")
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
