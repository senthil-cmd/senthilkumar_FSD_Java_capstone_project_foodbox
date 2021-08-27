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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.AdressDao;
import com.foodbox.model.Address;
import com.foodbox.model.Cuisines;

@RestController
@RequestMapping("api/address")
public class AddressRest { 
	@Autowired
	AdressDao adddao;
	@GetMapping("/")
	public List<Address> getalladdress() {
		return  (List<Address>) adddao.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> addaddress(@RequestBody Address address)
{
		adddao.save(address);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(address.getId()).toUri();  
		return ResponseEntity.created(location).build();
		
}
	@DeleteMapping("/{id}")
	public boolean deleteaddress(@PathVariable int id) {
		Optional<Address> add = adddao.findById(id);
		if(add.isPresent()) {
			adddao.deleteById(id);
			return true;
		}
		return false ;
}
	@PutMapping("/")
	public Address updateaddress(@RequestBody Address address) {
		Optional<Address> add = adddao.findById(address.getId());
		if(add.isPresent()) {
			adddao.save(address);
			return add.get();
		}
		
		return null;
	}
	@GetMapping("/{id}")
	public Address retriveaddress(@PathVariable int id){
		Optional<Address> add = adddao.findById(id);
		if(add.isPresent()) {
			
			Address address  = add.get();	
			return address ;
		}
		return null ;
	}
}