package com.patternsClass.DMS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.patternsClass.DMS.Models.Dog;

public interface DogRepository extends CrudRepository<Dog, Integer>{
	List<Dog> findByName(String name);

}
