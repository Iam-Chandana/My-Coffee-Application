package com.scratch.coffeeapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.scratch.coffeeapplication.model.Order;
import com.scratch.coffeeapplication.service.OrderService;

@RestController
@RequestMapping("/Orders")
public class OrderController {
	
	 
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService=orderService;
	}
	//list all orders
	@GetMapping("/displayall")
	public List<Order>  displayAllOrders() {
		return orderService.getAllOrders();
	}
	
	//list order by id
	@GetMapping("/orderById/{id}")
	public Optional<Order> displayOrderById(@PathVariable(name="id") Long id) {
		return orderService.getOrderById(id);
	}
	
	//order created
	
	@PostMapping("/createOrder")
	public Order addOrder(@RequestBody Order order) {
		orderService.createOrder(order);
		return order;
	}

	@PutMapping("/editOrder/{id}")
	public ResponseEntity<Order> editOrder(@PathVariable("id") long id,@RequestBody Order updateOrder) {
 
		Optional<Order> existingOrderOptional = orderService.getOrderById(id);
		if(!existingOrderOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Order existingOrder = existingOrderOptional.get();
		existingOrder.setOrder_name(updateOrder.getOrder_name());
		existingOrder.setCoffees(updateOrder.getCoffees());
		existingOrder.setTotal_price(orderService.calculateTotalPrice(updateOrder.getCoffees()));
		
		Order saveOrder = orderService.updateOrder(id, existingOrder);
		return ResponseEntity.ok(saveOrder);
	}
}

 
