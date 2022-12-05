package ru.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.model.Product;
import ru.spring.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct (@RequestParam(name = "min",required = false) Double minCost, @RequestParam(name = "max",required = false) Double maxCost) {
        return productService.getAllProduct(minCost, maxCost);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product save(Product product) {
       return productService.save(product);
    }

    @GetMapping ("/delete/{id}")
    public void  deleteProductById (@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
