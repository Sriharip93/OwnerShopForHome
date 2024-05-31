package com.srihari.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.srihari.dto.LoginRequest;
import com.srihari.dto.UserRequest;
import com.srihari.entity.Owner;
import com.srihari.entity.Products;
import com.srihari.entity.User;
import com.srihari.service.Ownerservice;
import com.srihari.util.JwtUtil;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/owner")

@RestController
public class OwnerController {

@Autowired	
private Ownerservice ownerservice;	
 private String username;
@Autowired
private JwtUtil jwtUtil;

Logger logger=LoggerFactory.getLogger(OwnerController.class);

 Owner owner;
@PostMapping("/login")
public ResponseEntity<?> ownerLogin(@RequestBody LoginRequest loginRequest) 
{
	List<Owner> list = ownerservice.getOwnerlist();
	
	
	Boolean flag =false;

	if(list == null)
	{
		logger.info("failed");
	}
	else
	{
		for(Owner  o:list)
		{
			if(o.getId()==loginRequest.getId()&& o.getPassword().equals(loginRequest.getPassword()))
			{
				username=o.getownername();
				flag=true;
			}
		}
		
	}
	if(flag ==true)
	{
		String token = jwtUtil.generateToken(username);
		
		return new ResponseEntity<>(token, HttpStatus.CREATED);
	}
	else
	{
		return new ResponseEntity<>("bad or invalid credentials ", HttpStatus.BAD_REQUEST);
	}
	
}

@PostMapping("/register")
public ResponseEntity<?> ownerRegister(@RequestBody Owner registerowner) 
{
	
	 owner=ownerservice.getById(registerowner.getId());
	 
	 if(owner == null)
	 {
		 ownerservice.register(registerowner);
		 return new ResponseEntity<>("resistered succssfull ", HttpStatus.CREATED);
	 }
	 else
	 {
		 return new ResponseEntity<>(" allredy registered", HttpStatus.BAD_REQUEST);
	 }

	} 
// user


@GetMapping("/Userlist")
public ResponseEntity<?> userDetails()

{
List<User> list=	ownerservice.getUserList();
return  new ResponseEntity<>(list,HttpStatus.OK);
}


@PostMapping("/addUser")
public ResponseEntity<?> userAdd(@RequestBody User user)

{
	
	ownerservice.addUser(user);
	return new ResponseEntity<>("succssfull add " ,HttpStatus.CREATED);
}

@PutMapping("/updateUser")
public ResponseEntity<?> editeUser(@RequestBody User user)
{
 User	 user1 = ownerservice.getbyId(user.getId());
	 
	 if(user1 == null)
	 {
		 return new ResponseEntity<>("user does not exist can't update" ,HttpStatus.NOT_FOUND);
	 }
	ownerservice.userUpdate(user);
	
	return new ResponseEntity<>("succssfull updated" ,HttpStatus.OK);
	
}

@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<?> deleteUser(@PathVariable Integer id)
{

User user1= ownerservice.getbyId(id);
	 
	 if(user1 == null)
	 {
		 return new ResponseEntity<>("user does not exist can't delete " ,HttpStatus.NOT_FOUND);
	 }
	
	ownerservice.userDelete(id);
	 return new ResponseEntity<>("succssfull deleted" ,HttpStatus.OK);
	
	 
}

//products methods

@GetMapping("/productlist")
public ResponseEntity<?> productlist()
{
	
List<Products> list=	ownerservice.productlist();

return  new ResponseEntity<>(list,HttpStatus.OK);
}

@PostMapping("/addProduct")
public ResponseEntity<?> userAdd(@RequestBody Products products)

{
	
	ownerservice.addProduct(products);
	return new ResponseEntity<>("succssfull add " ,HttpStatus.CREATED);
}


@PutMapping("/updateProducts")
public ResponseEntity<?> editeUser(@RequestBody Products products)
{
	 Products products2 = ownerservice.getbyIdProduct(products.getProductId());
	 
	 if(products2 == null)
	 {
		 return new ResponseEntity<>("productr does not exist can't  update" ,HttpStatus.NOT_FOUND);
	 }
	 ownerservice.productsUpdate(products);
	
	return new ResponseEntity<>("succssfull updated" ,HttpStatus.OK);
	
}

@DeleteMapping("/deleteProduct/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable Integer id)
{

Products products = ownerservice.getbyIdProduct(id);
	 
	 if(products == null)
	 {
		 return new ResponseEntity<>("product does not exist can't delete " ,HttpStatus.NOT_FOUND);
	 }
	
	 ownerservice.productDelete(id);
	 return new ResponseEntity<>("succssfull deleted" ,HttpStatus.OK);
	
	 
}

@GetMapping("/categoryProducts/{category}")
public List<Products>  categoryProducts(@PathVariable String category)
{
	
	List<Products> list = ownerservice.categoryproducts(category);
	
	
		 return list;
	 
}
 //merge purpose

@GetMapping("/getUserById/{id}")
public User getUserById(@PathVariable Integer id)
{
	
	return ownerservice.getbyId(id);
	
}
}
