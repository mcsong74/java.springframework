package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value="/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    //create Product - POST
    @PostMapping
    public List<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    //Delete Product -DELETE
    @DeleteMapping(value="/{id}")
    public List<Product> deleteProduct(@PathVariable("id") long id){
        return productService.delete(id);
    }

    //Update Product - @RequestBody - PUT
    @PutMapping(value="/{id}")
    public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }



}
