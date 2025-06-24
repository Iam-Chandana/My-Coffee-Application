package com.scratch.coffeeapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scratch.coffeeapplication.model.Coffee;
import com.scratch.coffeeapplication.repository.CoffeeRepository;

@Service
public class CoffeeService {
	
	private CoffeeRepository coffeeRepository;
	private List<Coffee> coffees;
	public CoffeeService(CoffeeRepository coffeeRepository,List<Coffee> coffees) {
		this.coffeeRepository= coffeeRepository;
		this.coffees=coffees;
	}
	
	
	//Add Coffee
	public String addCoffee(Coffee coffee) throws DuplicateIdExists, DuplicateNameExists {
		if(containsId(coffee.getCoffee_id())) {
			throw new DuplicateIdExists("Error: Coffee with that Id Already exists..!");
		}
		if(containsName(coffee.getCoffee_name())) {
			throw new DuplicateNameExists("Error: Coffee Name Already Exists..!");
		}
		
		coffeeRepository.save(coffee);
		System.out.println("New Coffee added Sucessfully");
		return "Coffee added";
		
	}
	
	
	//List all Coffees
	public List<Coffee> showCoffeeList() {
		return coffeeRepository.findAll();	
	}
	
	//get coffeedetails by Id
	public String getCoffeeById(int coffee_id) {
		Optional<Coffee> coffees = coffeeRepository.findById(coffee_id);
		if(coffees!=null) {
			return "Coffee Details: " +coffees;
			}else {
		return "Coffee Not Found..";
		}	
	}
	
	//update coffee by id
    public Coffee updateCoffee(int id, Coffee updatedCoffee) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(id);
        if (optionalCoffee.isPresent()) {
            Coffee coffee = optionalCoffee.get();
            coffee.setCoffee_name(updatedCoffee.getCoffee_name());
            coffee.setPrice(updatedCoffee.getPrice());
            return coffeeRepository.save(coffee);
        } else {
            // Handle error - Coffee not found
            return null;
        }
    }

	//Delete Coffee by Id
	public String deleteCoffeeById(int id) {
		Optional<Coffee> coffees= coffeeRepository.findById(id);
		if(coffees.isPresent()) {
			coffeeRepository.deleteById(id);
			return "Coffee deleted sucessfully";
		}
		return "Coffee With That Id Doesnot Exist";
		
	}
	
	
	private boolean containsName(String coffee_name) {
		for(Coffee c:coffees) {
			if(c.getCoffee_name().equalsIgnoreCase(coffee_name)) {
				return true;
			}}
 		return false;
	}

	private boolean containsId(int coffee_id) {
		for(Coffee c:coffees) {
			if(c.getCoffee_id()==coffee_id) {
				return true;
			}}
 		return false;
	}	
	}

