package ru.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.model.Product;
import ru.spring.repisitory.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
       return productRepository.save(product);
    }

    @GetMapping ("/delete/{id}")
    public void  deleteProductById (@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
