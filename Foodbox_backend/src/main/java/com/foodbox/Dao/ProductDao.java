package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Product;
@Repository
public interface ProductDao extends CrudRepository<Product, Integer > {
 

}
