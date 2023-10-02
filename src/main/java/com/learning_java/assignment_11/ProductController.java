package com.learning_java.assignment_11;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get all products in the database
     * @return list of all products
     */
    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> productList = productService.getProducts();
        log.debug("List of all product fetched : " + productList);
        if (productList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    /**
     * Get all categories in the database
     * @return list of categories
     */
    @GetMapping("/categories")
    public ResponseEntity<List<String>> allCategories() {
        List<String> productList = productService.getAllCategory();
        log.debug("List of all product fetched : " + productList);
        if (productList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<String>>(productList, HttpStatus.OK);
    }

    /**
     * Get all products in category
     * @param category
     * @return list of products in the category
     */
    @GetMapping("/product/{category}")
    public ResponseEntity<List<Product>> findProductByCategory(@PathVariable String category) {
        log.info("Fetching Products in category" + category);
        List<Product> productList = productService.getAllProductsACategory(category);
        log.debug("List of all product fetched : " + productList);
        if (productList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);

    }

    /**
     * Add a product into database
     * @param product
     * @return Product that is added into the database
     */
    @ResponseStatus(value=HttpStatus.CREATED)
    @PostMapping(value = "/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product newProduct = productService.saveProduct(product);
            log.debug("Added product ", newProduct);
            return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update a product with a particular id
     * @param product
     * @return the updated product
     */
    @PutMapping(value = "/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
       log.debug("Updating Product with id {}", product.getId());
        try {
            Product newProduct = productService.updateProduct(product);
            log.debug("Added product ", newProduct);
            return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

   }

}

