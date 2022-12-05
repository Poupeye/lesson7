package ru.spring.repisitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
