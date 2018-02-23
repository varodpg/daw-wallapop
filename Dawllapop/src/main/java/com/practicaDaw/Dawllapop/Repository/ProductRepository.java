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
	@Query(value = "SELECT * FROM Product u WHERE u.category like ':categoria[id]' and state like ':state' ORDER BY ?#{#pageable}", nativeQuery=true)
	Page<Product> findByCategoryFiltering(Pageable pageable, @Param("categoria") Category categoria, @Param("state") String state);
	
	@Query(value = "SELECT * FROM PRODUCT u WHERE state = ':state' ORDER BY ?#{#pageable}", 
			countQuery = "SELECT count(*) FROM PRODUCT",
			nativeQuery=true)
	Page<Product> findByCategoryFilteringExample(Pageable page, @Param("state") String state);
}
