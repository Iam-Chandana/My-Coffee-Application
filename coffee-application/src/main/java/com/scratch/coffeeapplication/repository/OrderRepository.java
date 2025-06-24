package com.scratch.coffeeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scratch.coffeeapplication.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
