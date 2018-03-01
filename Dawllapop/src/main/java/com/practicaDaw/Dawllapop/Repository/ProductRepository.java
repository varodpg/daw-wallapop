package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Entities.User;



public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findAll(Pageable pageable);
	Page<Product> findByCategory(Pageable pageable, Category categoria);
	Long countByCategory(Category categoria);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state /*#pageable*/", 
			countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state",
			nativeQuery=true)
	Page<Product> findByCategoryFiltering(@Param("p_low") String price_low, @Param("p_top") String price_top, @Param("state") String state, @Param("category") Category category, Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state1 OR CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state2 /*#pageable*/", 
			countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state1 OR CATEGORY_ID= :category AND price > :p_low AND price < :p_top AND state = :state2",
			nativeQuery=true)
	Page<Product> findByCategoryFiltering2(@Param("p_low") String price_low, @Param("p_top") String price_top, @Param("state1") String state1, @Param("state2") String state2, @Param("category") Category category, Pageable pageable);
	
	@Query(value = "SELECT * FROM PRODUCT WHERE state = :state /*#pageable*/", 
			countQuery = "SELECT COUNT(*) FROM PRODUCT WHERE state = :state",
			nativeQuery=true)
	Page<Product> findByCategoryFilteringExample(@Param("state") String state, Pageable pageable);

	Page<Product> findByUser(Pageable pageable, User user);
	
	//By the time the query just shows 4 products because the view only can load 4
	@Query(value = "SELECT * FROM product WHERE UPPER(name) LIKE CONCAT('%', CONCAT(UPPER(:name), '%')) LIMIT 4", nativeQuery = true)
	List<Product> searchByName(@Param("name") String name);
	
	//queries for index
	List<Product> findFirst10ByUserLocation(String location);
	List<Product> findFirst8ByOrderByDateDesc();
	
	//queries for dashboard (user page)
	List<Product> findAllByUserId(Long id);
	
	List<Product> findDistinctByUserIdAndOffersStateAndSold(long id, int state, boolean sold);
//	@Query(value = "SELECT * FROM OFFER WHERE STATE= :state_offer AND PRODUCT_ID IN (SELECT ID FROM PRODUCT WHERE USER_ID= :user_id", nativeQuery = true)
//	List<Product> findAllProductsByState( @Param("user_id") long user_id, @Param("state_offer") int state_offer);
//	
//	
	List<Product> findAllDistinctBySoldAndOffersBuyerId(boolean sold, Long id);
	
}


