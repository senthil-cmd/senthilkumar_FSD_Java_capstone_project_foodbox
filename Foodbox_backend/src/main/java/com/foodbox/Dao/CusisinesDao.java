package com.foodbox.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.model.Cuisines;
@Repository
public interface CusisinesDao extends CrudRepository<Cuisines, Integer>{

}
