package com.scratch.coffeeapplication.service;
 
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scratch.coffeeapplication.model.Coffee;
import com.scratch.coffeeapplication.model.Order;
import com.scratch.coffeeapplication.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired 
	private OrderRepository orderRepository;
	
	//get all orders
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	//get order by id
	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}
	
	
	//create order
	public Order createOrder(Order order){
		 if (order.getCoffees() == null) {
		         
		        throw new IllegalArgumentException("Items field cannot be null");
		    }
		double totalprice= calculateTotalPrice(order.getCoffees());
		order.setTotal_price(totalprice);
		
		return orderRepository.save(order);
	}
	
	//update order by id
	
	public Order updateOrder(Long id, Order updateOrder) {
		Optional<Order> existingOrderOptional = orderRepository.findById(id);
		if(existingOrderOptional.isPresent()) {
			 Order existingOrder = existingOrderOptional.get();
 			 existingOrder.setOrder_name(updateOrder.getOrder_name());
			 existingOrder.setCoffees(updateOrder.getCoffees());
			 existingOrder.setTotal_price(calculateTotalPrice(updateOrder.getCoffees()));
			 
			 return orderRepository.save(existingOrder);
			
		}else {
			return null;
		}
	}
	

	//delete order by id
	public String deleteOrderById(Long id) {
		orderRepository.deleteById(id);
		return "Order Deleted Sucessfully";
	}
	
	public double calculateTotalPrice(List<Coffee> items) {
		double total_price= 0.0;
		for(Coffee c:items) {
			total_price += c.getPrice();
		}
 		return total_price;
	}

}

