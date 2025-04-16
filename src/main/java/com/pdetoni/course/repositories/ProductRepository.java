package com.pdetoni.course.repositories;

import com.pdetoni.course.entities.Category;
import com.pdetoni.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
