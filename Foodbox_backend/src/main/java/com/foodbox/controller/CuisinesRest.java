package com.foodbox.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.CusisinesDao;
import com.foodbox.model.Cuisines;

@RestController
@RequestMapping("api/cuisines")
public class CuisinesRest {
	
	
	@Autowired
	CusisinesDao cuidao;
	
	// view all cuisine
	@GetMapping("/")
	public List<Cuisines> getallcuisines() {
		return  (List<Cuisines>) cuidao.findAll();
	}
	@PostMapping("/")
	public  ResponseEntity<Object> addcuisines(@RequestBody Cuisines cusine) {
		
		cuidao.save(cusine);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cusine.getId()).toUri();  
		return ResponseEntity.created(location).build();
		
	}
	@DeleteMapping("/{id}")
	public boolean deletecuisines(@PathVariable int id) {
		Optional<Cuisines> cu = cuidao.findById(id);
		if(cu.isPresent()) {
			cuidao.deleteById(id);
			return true;
		}
		return false ;
		
	}
	
	@GetMapping("/{id}")
	public Cuisines retrivecuisines(@PathVariable int id){
		Optional<Cuisines> cu = cuidao.findById(id);
		if(cu.isPresent()) {
			
			Cuisines cuisine = cu.get();	
			return cuisine ;
		}
		return null ;
	}
	
	@PutMapping("/{id}")
	public Cuisines updateCusisines(@RequestBody Cuisines ucusine,@PathVariable int id ) {
		Optional<Cuisines> cu = cuidao.findById(id);
		if(cu.isPresent()) {
			
			Cuisines cuisine = cu.get();
			cuisine.setDescription(ucusine.getDescription());
			cuisine.setName(ucusine.getName());
			cuidao.save(cuisine);
			return cuisine;
		}
		
		return null;
	}
}
