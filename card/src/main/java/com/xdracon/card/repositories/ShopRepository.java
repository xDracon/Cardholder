package com.xdracon.card.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xdracon.card.entities.Shop;

import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    Optional<Shop> findByName(String name);
}
