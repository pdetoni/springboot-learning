package com.pdetoni.course.repositories;

import com.pdetoni.course.entities.Order;
import com.pdetoni.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
