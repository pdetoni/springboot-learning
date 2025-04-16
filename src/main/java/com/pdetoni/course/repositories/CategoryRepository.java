package com.pdetoni.course.repositories;

import com.pdetoni.course.entities.Category;
import com.pdetoni.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
