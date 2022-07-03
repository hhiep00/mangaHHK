package com.pro.manga.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.manga.domain.Account;
import com.pro.manga.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findByNameContaining(String name);
	Page<Category> findByNameContaining(String name, Pageable pageable);
	
	Category findByName(String categoryName);
}
