package com.salle.avillanueva.productos_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salle.avillanueva.productos_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
