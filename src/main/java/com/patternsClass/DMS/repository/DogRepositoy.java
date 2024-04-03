package com.patternsClass.DMS.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import com.patternsClass.DMS.Models.Dog;


public interface DogRepositoy extends CrudRepository<Dog,Integer>{
	List<Dog> findByName(String name);

}
