package com.app.service;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.Subscriber;

public interface AdminService {

	List<Subscriber> getAllsubscriberDetails();
	List<Product> getAllProductDetails();
	List<Order> getAllOrderDetails();
	
	String deleteSubscriber(int id);
}
