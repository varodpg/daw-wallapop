package com.practicaDaw.Dawllapop.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.practicaDaw.Dawllapop.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	Page<Product> findAll(Pageable pageable);
}
