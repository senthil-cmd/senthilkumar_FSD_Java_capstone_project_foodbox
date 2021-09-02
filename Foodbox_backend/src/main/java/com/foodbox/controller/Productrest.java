package com.foodbox.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.CusisinesDao;
import com.foodbox.Dao.ProductDao;
import com.foodbox.model.Address;
import com.foodbox.model.Cuisines;
import com.foodbox.model.Product;

@RestController
@RequestMapping("api/product")
public class Productrest {
	@Autowired
	ProductDao prdao;
	@Autowired
	CusisinesDao cudao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public List<Product> getallproduct() {
		return  (List<Product>) prdao.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public ResponseEntity<Object> addproduct(@RequestBody Product prd ){
		Optional<Cuisines>cu = cudao.findById(prd.getCuisine().getId());
		prd.setCuisine(cu.get());
		prdao.save(prd);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prd.getId()).toUri();  
		return ResponseEntity.created(location).build();		
}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public boolean deleteproduct(@PathVariable int id) {
		Optional<Product> prd = prdao.findById(id);
		if(prd.isPresent()) {
			prdao.deleteById(id);
			return true;
		}
		return false ;
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product updateproduct(@RequestBody Product prd,@PathVariable int id) {
		Optional<Product> pt = prdao.findById(id);
		Optional<Cuisines>cu = cudao.findById(prd.getCuisine().getId());
		prd.setCuisine(cu.get());
		if(pt.isPresent()) {
			prdao.save(prd);
			return prd;
		}
		return null;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public Product retrivepdt(@PathVariable int id){
		Optional<Product> pdt = prdao.findById(id);
		if(pdt.isPresent()) {
			
			Product pdtb  = pdt.get();	
			return pdtb ;
		}
		return null ;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PatchMapping("isavliable/{id}/{status}")
	public Product updateavilable(@PathVariable int id,@PathVariable boolean status){
		Optional<Product> pdt = prdao.findById(id);
		if(pdt.isPresent()) {
		Product pdb = pdt.get();
		pdb.setIs_active(status);
		prdao.save(pdb);
		return pdb;
		}
		return null;
		}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/avilable")
	public List<Product> avilableproduct() {
		
		List<Product> pdt = (List<Product>) prdao.findAll();
		
		List<Product> pdtavilable =  pdt.stream().filter(p->p.isIs_active()).collect(Collectors.toList());
		return  pdtavilable;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/bycuisines/{cuisine}")
	public List<Product> bycuisines(@PathVariable String cuisine) {
		
		List<Product> pdt = (List<Product>) prdao.findAll();
		
		List<Product> pdtbycusines =  pdt.stream().filter(p->p.getCuisine().getName().equals(cuisine)).collect(Collectors.toList());
		return  pdtbycusines;
	}
	@PostMapping("/bulk")
	public void addproducts(@RequestBody List<Product> prd) {
		
		prdao.saveAll(prd);
		
	}
	}
