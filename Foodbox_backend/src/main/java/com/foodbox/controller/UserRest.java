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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.foodbox.Dao.UserDao;
import com.foodbox.model.Product;
import com.foodbox.model.User;

@RestController
@RequestMapping("api/user")
public class UserRest {

@Autowired
UserDao usrdao;

@GetMapping("/")
public List<User> getalluser() {
	return  (List<User>) usrdao.findAll();
}
@PostMapping("/")
public ResponseEntity<Object> adduser(@RequestBody User user ){
	usrdao.save(user);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();  
	return ResponseEntity.created(location).build();
}
@PostMapping("/login")
public User userlogin(@RequestParam("uemail") String email,@RequestParam("Pass") String password){
User user = usrdao.findByemail(email);	
if(!(user==null)) {
if(user.getPassword().equals(password)){
	return user;
}
}
return null;
}
@PutMapping("/")
public User updateuser(@RequestBody User usr) {
	Optional<User> ur = usrdao.findById(usr.getId());
	if(ur.isPresent()) {
		usrdao.save(usr);
		return usr;
	}
	return null;
}
@DeleteMapping("/{id}")
public boolean deleteuser(@PathVariable int id) {
	Optional<User> ur = usrdao.findById(id);
	if(ur.isPresent()) {
		usrdao.deleteById(id);
		return true;
	}
	return false ;

}
}


