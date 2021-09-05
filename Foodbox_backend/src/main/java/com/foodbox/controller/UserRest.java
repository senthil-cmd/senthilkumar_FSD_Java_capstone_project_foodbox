package com.foodbox.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.UserDao;
import com.foodbox.errorhandling.InvaliedrequestException;
import com.foodbox.model.Product;
import com.foodbox.model.User;

@RestController
@RequestMapping("api/user")
public class UserRest {

@Autowired
UserDao usrdao;

@GetMapping("/")
//@CrossOrigin(origins = "http://52.90.241.192:4200")

public List<User> getalluser() {
	return  (List<User>) usrdao.findAll();
}
@PostMapping("/")
//@CrossOrigin(origins = "http://52.90.241.192:4200")
public ResponseEntity<Object> adduser(@RequestBody User user ){
	usrdao.save(user);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();  
	return ResponseEntity.created(location).build();
}
@PostMapping("/login")
//@CrossOrigin(origins = "http://52.90.241.192:4200")
public User userlogin(@RequestBody User user){
User userdb = usrdao.findByemail(user.getEmail());	
if(!(userdb==null)) {
if(userdb.getPassword().equals(user.getPassword())){
	return userdb;
}
}
 throw new InvaliedrequestException("Invalied email or password ");
}
@CrossOrigin(origins = "http://52.90.241.192:4200")
@PutMapping("/{id}")
public User updateuser(@PathVariable int id,@RequestBody User user) {
	Optional<User> ur = usrdao.findById(id);
	if(ur.isPresent()) {
		usrdao.save(user);
		return user;
	}
	throw new InvaliedrequestException("Invalied user id:"+id);
}
//@CrossOrigin(origins = "http://52.90.241.192:4200")
@DeleteMapping("/{id}")
public boolean deleteuser(@PathVariable int id) {
	Optional<User> ur = usrdao.findById(id);
	if(ur.isPresent()) {
		usrdao.deleteById(id);
		return true;
	}
	throw new InvaliedrequestException("Invalied user id:"+id);

	
}

//@CrossOrigin(origins = "http://52.90.241.192:4200")
@GetMapping("/{id}")
public User Retervieuser(@PathVariable int id) {
	Optional<User> ur = usrdao.findById(id);
	if(ur.isPresent()) {
		
		return ur.get();
	}
	throw new InvaliedrequestException("Invalied user id:"+id);

}
}


