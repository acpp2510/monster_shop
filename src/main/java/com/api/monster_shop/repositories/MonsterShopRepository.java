package com.api.monster_shop.repositories;

import com.api.monster_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MonsterShopRepository extends JpaRepository<Product, Long> {
}
