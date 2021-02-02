package com.techlabs.shristi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.shristi.model.Order;
import com.techlabs.shristi.model.Product;
import com.techlabs.shristi.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping
	public Order getOrderDetails() {
		return orderService.getOrderDetails();
	}
	
	
	@GetMapping("/{category}/{brand}")
	public List<Product> getAllProductsByCategory(@PathVariable("category") String category, @PathVariable("brand") String brand){
		return orderService.getAllProducts(category, brand);
	}
}
