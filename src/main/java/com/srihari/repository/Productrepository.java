package com.srihari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.srihari.entity.Products;

@Repository
public interface Productrepository  extends JpaRepository<Products, Integer> {

	@Query(value ="select * from products where  product_category=?1",nativeQuery=true)
	
	public List<Products> selectcategoryProducts(String category);
}
