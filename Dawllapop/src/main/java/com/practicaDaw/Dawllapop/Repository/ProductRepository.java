package com.practicaDaw.Dawllapop.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;

import antlr.collections.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findAll(Pageable pageable);
	Page<Product> findByCategory(Pageable pageable, Category categoria);
	Long countByCategory(Category categoria);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY_ID= :category AND state = :state /*#pageable*/", 
			countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY_ID= :category AND state = :state",
			nativeQuery=true)
	Page<Product> findByCategoryFiltering(@Param("state") String state, @Param("category") Category category, Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE state = :state /*#pageable*/", 
			countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE state = :state",
			nativeQuery=true)
	Page<Product> findByCategoryFilteringExample(@Param("state") String state, Pageable pageable);
	
	
	
}


