package com.foodbox.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.User;
@Repository
public interface UserDao extends JpaRepository <User , Integer> {

	User findByemail(String emailAddress);
}
