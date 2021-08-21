package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cart_line;
@Repository
public interface Cart_lineDao extends CrudRepository<Cart_line ,Integer>{

}
