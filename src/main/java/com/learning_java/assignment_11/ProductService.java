package com.learning_java.assignment_11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public List<String> getAllCategory() {
        return productDao.findAllCategories();
    }


    public List<Product> getAllProductsACategory(String categoryName) {
        return productDao.findProductsACategory(categoryName);
    }

    public Product saveProduct(Product product) {
        return productDao.save(product);
    }

    public Product updateProduct(Product product) {
       return productDao.save(product);
    }

    public Product getById(Integer id) {
       return productDao.findById(id).get();
        }
}
