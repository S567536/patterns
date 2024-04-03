package com.anjanaClasses.DMS.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anjanaClasses.DMS.Models.Dog;

/**
 * @author S546941
 *
 */
public interface DogRepository extends CrudRepository<Dog,Integer>{

	List<Dog> findByName(String name);
	
	

}
