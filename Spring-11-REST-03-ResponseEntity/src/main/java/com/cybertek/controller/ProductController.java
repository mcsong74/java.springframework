package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){

        return ResponseEntity.ok(productService.getProduct(id));
//        return productService.getProduct(id);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        //adding custom header, way 1 - HttpHeaders
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "v1.0.0.12");
        responseHttpHeaders.set("Operation", "Get List");
        //For ResponseEntity, need to pass 3 things: status, header, body
        //return type need to be changed ResponseEntity<List<Product>>
        return ResponseEntity.ok()//.ok == status 200
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    //create Product - POST
    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product){
        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Cybertek.v1.0.0.1")
                .header("Operation", "Create ")
                .body(set);

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
