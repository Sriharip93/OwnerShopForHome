package com.srihari.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srihari.entity.Owner;
import com.srihari.entity.Products;
import com.srihari.entity.User;
import com.srihari.repository.OwnerRepository;
import com.srihari.repository.Productrepository;
import com.srihari.repository.UserRepository;
import com.srihari.service.Ownerservice;


@Service
public  class Ownerserviceimpl  implements Ownerservice{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Productrepository productrepository;

	@Override
	public List<Owner> getOwnerlist() {
	
		List<Owner> list = ownerRepository.findAll();
		return list;
	}

	@Override
	public Owner getById(Integer id) {
		
		Owner owner = ownerRepository.findById(id).orElse(null);
		return owner;
	}

	@Override
	public void register(Owner owner) {
	
		ownerRepository.save(owner);
		
	}

	
// users
	
	

	
	@Override
	public List<User> getUserList() {
		List<User> list = userRepository.findAll();
		return list;	
	}

	
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	
	@Override
	public User userEdite(Integer id) {
		
		User list = userRepository.getById(id);
		return list;
	}


	@Override
	public void userUpdate(User list) {
		
		userRepository.save(list);
	}


	@Override
	public void userDelete(Integer id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public User getbyId(Integer id) {
		
		  return userRepository.findById(id).orElse(null);
		
	}

	
	//products
	
	@Override
	public List<Products> productlist() {
		
		List<Products> list = productrepository.findAll();
		return list;
	}

	@Override
	public void addProduct(Products products) {
		
		productrepository.save(products);
		
	}

	@Override
	public Products getbyIdProduct(Integer productId) {
		
		return  productrepository.findById(productId).orElse(null);
		
	}

	@Override
	public void productsUpdate(Products products) {
		
		productrepository.save(products);
		
	}

	@Override
	public void productDelete(Integer id) {


		productrepository.deleteById(id);
	}

	@Override
	public List<Products> categoryproducts(String category) {

		return	productrepository.selectcategoryProducts(category);
		 
	}

	



	
}
