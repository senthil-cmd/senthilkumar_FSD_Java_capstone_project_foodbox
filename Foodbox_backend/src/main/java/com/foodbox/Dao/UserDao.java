package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.User;
@Repository
public interface UserDao extends CrudRepository <User , Integer> {

}
