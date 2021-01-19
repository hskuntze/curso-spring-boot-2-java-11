package com.KuntzeProjects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KuntzeProjects.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
