package com.scratch.coffeeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scratch.coffeeapplication.model.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

}
