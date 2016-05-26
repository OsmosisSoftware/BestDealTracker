package Repositories;


import Entities.AmazonItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface AmazonItemRepository extends JpaRepository<AmazonItem, Long> {
    Collection<AmazonItem> findByname(String nombre);
}

