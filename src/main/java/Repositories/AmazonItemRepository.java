package Repositories;


import Entities.AmazonItem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AmazonItemRepository extends JpaRepository<AmazonItem, Long> {
    Collection<AmazonItem> findByname(String nombre);
}

