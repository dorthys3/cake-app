package com.example.Cake.repository;

import com.example.Cake.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeRepository extends JpaRepository<Cake, Long> {
    List<Cake> findByNameContainingIgnoreCase(String name);
}
