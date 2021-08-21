package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cart;
@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{

}
