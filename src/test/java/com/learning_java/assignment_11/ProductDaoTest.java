package com.learning_java.assignment_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    void findAll() {
        try{
            List <Product> productList = productDao.findAll();
            assertThat(productList).size().isGreaterThan(0);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void findAllCategories() {
        try{
            List <String> categoryList = productDao.findAllCategories();
            assertNotNull(categoryList);
            assertThat(categoryList).size().isGreaterThan(0);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void findProductsACategory() {
        try {
            List<Product> productList = productDao.findProductsACategory("Electronics");
            assertThat(productList).size().isGreaterThan(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void save() {
        try{
            Product product =new Product(6,"Redmi Earphone", new BigDecimal(600),1);
            Product newProduct = productDao.save(product);
            assertEquals(product,newProduct);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}