package com.foodbox.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.Cart_lineDao;
import com.foodbox.model.Cart_line;
@RestController
@RequestMapping("api/cart_line")
public class Cart_linerest {
	@Autowired
	Cart_lineDao cartldao;
	//@CrossOrigin(origins = "http://52.90.241.192:4200")
	@GetMapping("/")
	public List<Cart_line> getallcartlline() {
		return  (List<Cart_line>) cartldao.findAll();
	}
	@PostMapping("/")
	//@CrossOrigin(origins = "http://52.90.241.192:4200")
	public Cart_line addcart(@RequestBody Cart_line cart) {
		cartldao.save(cart);
		return cart;
		
	}
	@GetMapping("/{id}")
	//@CrossOrigin(origins = "http://52.90.241.192:4200")
	public Cart_line retrivecart(@PathVariable int id){
		Optional<Cart_line> cl = cartldao.findById(id);
		if(cl.isPresent()) {
			
			Cart_line cartl  = cl.get();	
			return cartl ;
		}
		return null ;
	}
		@PutMapping("/")
		//@CrossOrigin(origins = "http://52.90.241.192:4200")
		public Cart_line updatecart(@RequestBody Cart_line cart){
			Optional<Cart_line> cl = cartldao.findById(cart.getId());
			if(cl.isPresent()) {
				
				cartldao.save(cart);
				return cart;		
				
			}
			return null ;
		}
		
		@DeleteMapping("/{id}")
		//@CrossOrigin(origins = "http://52.90.241.192:4200")
		public boolean deleteproduct(@PathVariable int id) {
			Optional<Cart_line> cl = cartldao.findById(id);
			if(cl.isPresent()) {
				cartldao.deleteById(id);
				return true;
			}
			return false ;
		}
}
	
