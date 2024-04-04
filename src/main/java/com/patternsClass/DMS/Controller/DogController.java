package com.patternsClass.DMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.patternsClass.DMS.Models.Dog;

public class DogController {
	ModelAndView mv = new ModelAndView();
	@Autowired
	CrudRepository dogRepo ;
//	@RequestMapping("dogHome")
//	public String home() {
//		return "home";
//	}
	@RequestMapping("dogHome")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView add() {
		mv.setViewName("addNewDog.html");
		return mv;
	}
	
	
	@RequestMapping("addNewDog")
	public ModelAndView addNewDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("viewModifyDelete")
	public ModelAndView viewDogs() {
		mv.setViewName("viewDogs");
		Iterable<Dog> dogList = dogRepo.findAll();
		mv.addObject("dogs", dogList);
		return mv;
	} 
	
	@RequestMapping("editDog")
	public ModelAndView editDog(Dog dog) {
		dogRepo.save(dog);
		mv.setViewName("editDog");
		return mv;
	}
	
	@RequestMapping("deleteDog")
	public ModelAndView deleteDog(Dog dog) {
		//based in id
/*		Optional<Dog> dogFound = dogRepo.findById(dog.getId());
		if(dogFound.isPresent()) {
			dogRepo.delete(dog);
		}
		return home();*/
		
		//based on name
		
		//dogRepo.findById(dog.getName());
		
		 Dog d = (Dog) dogRepo.findById(dog.getId()).orElse(new Dog());
		dogRepo.delete(d);
		return home();
		
	}
	
	@RequestMapping("search")
	public ModelAndView searchById(int id) {
		Dog dogFound = (Dog) dogRepo.findById(id).orElse(new Dog());
		mv.addObject(dogFound);
		mv.setViewName("searchResults");
		return mv;
	}
}
