package com.scratch.coffeeapplication.controller;

 
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scratch.coffeeapplication.model.Coffee;
import com.scratch.coffeeapplication.service.CoffeeService;
import com.scratch.coffeeapplication.service.DuplicateIdExists;
import com.scratch.coffeeapplication.service.DuplicateNameExists;

@RestController
@RequestMapping("/home")

public class CoffeeController {

	@Autowired private CoffeeService coffeeService;
	
	/*public CoffeeController(CoffeeService coffeeService) {
		this.coffeeService = coffeeService;
	}*/
	
	private final org.slf4j.Logger logger =  LoggerFactory.getLogger(CoffeeController.class);
	@GetMapping("/hello")
	public String hello() {
		return "Hello-World";
	}
	 @PostMapping("/addCoffee")
	 public String addNewCoffee(@RequestBody Coffee coffee) throws DuplicateIdExists, DuplicateNameExists {
		logger.info("Add coffee..");
		 coffeeService.addCoffee(coffee);
		 return "Coffee Added Sucessfully";
	 }
	 
	 
	 
	 @GetMapping("/{id}")
	 public String displayCoffeeById(@PathVariable(name="id") int id) {
		 String Coffee_Details=coffeeService.getCoffeeById(id);
		 System.out.println(Coffee_Details);
		 return Coffee_Details;
	 }
	 
	 @DeleteMapping("/id/{id}")
	 public String deleteCoffeeById(@PathVariable(name="id") int id) {
		 String Coffees= coffeeService.deleteCoffeeById(id);
		 return "Coffee with "+id +" Deleted Sucessfully";
	 }
}
