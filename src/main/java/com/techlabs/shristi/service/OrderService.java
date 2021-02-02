package com.techlabs.shristi.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techlabs.shristi.model.Order;
import com.techlabs.shristi.model.Product;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	private List<Product> products=new ArrayList<>();
	private double total=0;
	private int orderId=0;
	private final static String BASE_URI ="http://CART-SERVICE/cart"; 
	
	@HystrixCommand(fallbackMethod="getAllMockProducts")
	public List<Product> getAllProducts(String category, String brand){
		System.out.println("getAllProducts");
		List<LinkedHashMap<Integer, Object>> responseMap = restTemplate.getForObject(BASE_URI+"/many/"+category+"/"+brand, List.class);
		for(LinkedHashMap<Integer, Object> response: responseMap) {
			String brandRes = (String) response.get("brand");
			Integer productId = (Integer) response.get("id");
			String name = (String) response.get("name");
			Double price = (Double) response.get("price");
			total+=price;
			Product product = new Product(productId, name, category, price, brand);
			products.add(product);
		}
		return products;
	}
	
	public List<Product> getAllMockProducts(String category, String brand){
		System.out.println("getAllMockProducts");
		return new ArrayList<>();
	}
	
	public Order getOrderDetails() {
		Order order = new Order(++orderId,products,total);
		return order;
	}
}
