package ru.spring.repisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostBetween(Double minCost, Double maxCost);
    List<Product> findAllByCostIsGreaterThanEqual(Double minCost);
    List<Product> findAllByCostIsLessThanEqual(Double maxCost);

}
