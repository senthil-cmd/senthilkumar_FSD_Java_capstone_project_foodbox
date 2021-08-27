package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Address;
@Repository
public interface AdressDao extends CrudRepository <Address , Integer>{

}
