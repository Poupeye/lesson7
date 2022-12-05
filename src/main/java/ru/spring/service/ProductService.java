package ru.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.spring.model.Product;
import ru.spring.repisitory.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProduct(@RequestParam(name = "min", required = false) Double minCost, @RequestParam(name = "max", required = false) Double maxCost) {

        if ((minCost != null) & (maxCost != null)) {
            return productRepository.findAllByCostBetween(minCost,maxCost);
        } else if (minCost != null) {
            return productRepository.findAllByCostIsGreaterThanEqual(minCost);
        } else if (maxCost != null){
            return productRepository.findAllByCostIsLessThanEqual(maxCost);
        }
        return productRepository.findAll();
    }

    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

}
