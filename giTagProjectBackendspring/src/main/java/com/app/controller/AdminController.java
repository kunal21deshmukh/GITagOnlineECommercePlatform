package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressInfo;
import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.Subscriber;
import com.app.service.AdminService;
import com.app.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController
{

	@Autowired
	private AdminService adminService;
	public AdminController()
	{
		System.out.println("in admin controller");
	}
	
	//to get info about subscribers
    @GetMapping("/subscribers")
    public ResponseEntity<List<Subscriber>> getAllSubscriber()
    {  
   	  return  ResponseEntity.ok(adminService.getAllsubscriberDetails());
    }
    
  //to get info about products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {  
   	  return  ResponseEntity.ok(adminService.getAllProductDetails());
    }
    
  //to get info about orders
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders()
    {  
   	  return  ResponseEntity.ok(adminService.getAllOrderDetails());
    }
    
    @DeleteMapping("/subscriber/{subId}")
    public ResponseEntity<String> deleteSubscriberData(@PathVariable int subId)
    {
    	return  ResponseEntity.ok(adminService.deleteSubscriber(subId));
    }

}
