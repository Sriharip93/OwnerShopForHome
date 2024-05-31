package com.srihari.service;

import java.util.List;

import com.srihari.entity.Owner;
import com.srihari.entity.Products;
import com.srihari.entity.User;

public interface Ownerservice {

public List<Owner> getOwnerlist();

public Owner getById(Integer id);

public void register(Owner owner );


// users methods

public 	List<User> getUserList();

public void addUser(User user);

public User userEdite(Integer id);

public void userUpdate(User list);

public void userDelete(Integer id);

public User getbyId(Integer id);

//Product methods

public	List<Products> productlist();

public void addProduct(Products products);

public Products getbyIdProduct(Integer productId);

public void productsUpdate(Products products);

public void productDelete(Integer id);

//category

public List<Products> categoryproducts(String category);

}
