package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;


import com.foodbox.model.Product;

public interface ProductDao extends CrudRepository<Product, String > {
 

}
