package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderRepository;
import com.app.dao.ProductRepository;
import com.app.dao.SubscriberRepository;
import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.Subscriber;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private SubscriberRepository subscrRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public List<Subscriber> getAllsubscriberDetails() {
		List<Subscriber> findAll = subscrRepo.findAll();
		return findAll;
	}
	
	@Override
	public String deleteSubscriber(int id) {
		Subscriber findById = subscrRepo.findById(id).orElseThrow(()->new RuntimeException("no subscriber get"));
		subscrRepo.delete(findById);
		return "subscriber get deleted successfully";
	}

	@Override
	public List<Product> getAllProductDetails() {
		List<Product> findAll = productRepo.findAll();
		return findAll;
	}

	@Override
	public List<Order> getAllOrderDetails() {
		List<Order> findAll = orderRepo.findAll();
		return findAll;
	}

}
