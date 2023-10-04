package com.learning_java.assignment_11;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService;

    static Stream<Arguments> argsGetProducts() {
        List<Product> expectedProduct = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy",new BigDecimal(6000),1);
        expectedProduct.add(product);
        return Stream.of(
                arguments(expectedProduct)
        );
    }

    static Stream<Arguments> argsGetAllProductsACategory() {
        List<Product> expectedProduct = new ArrayList<>();
        Product product = new Product(1,"Samsung Galaxy",new BigDecimal(6000),1);
        expectedProduct.add(product);
        return Stream.of(
                arguments("Electronics",expectedProduct)
        );
    }

    static Stream<Arguments> argsGetAllCategory() {
        List<String> expected = new ArrayList<>();
        expected.add("Electronics");
        return Stream.of(
                arguments(expected)
        );
    }

    static Stream<Arguments> argsSaveProduct() {
        Product product =new Product(6,"Redmi Earphone", new BigDecimal(600),1);
        Product expectedProduct =new Product(5,"Redmi Earphone", new BigDecimal(600),1);
        return Stream.of(
                arguments(product, expectedProduct)
        );
    }

    static Stream<Arguments> argsUpdateProduct() {
        Product product =new Product(6,"Redmi Earphone", new BigDecimal(600),1);
        Product expectedProduct =new Product(5,"Redmi Earphone", new BigDecimal(600),1);
        return Stream.of(
                arguments(product, expectedProduct)
        );
    }

    @ParameterizedTest
    @MethodSource("argsGetProducts")
    void getProducts(List <Product> expectedProduct) {
        try {
            assertNotNull(productDao);
            when(productDao.findAll()).thenReturn(expectedProduct);

            List<Product> actualProduct = productService.getProducts();

            assertEquals(expectedProduct, actualProduct);
        } catch (Exception exception) {
            fail(exception);
        }
    }

    @ParameterizedTest
    @MethodSource("argsGetAllProductsACategory")
    void getAllProductsACategory(String category, List <Product> expectedProduct) {
        try {
            assertNotNull(productDao);
            when(productDao.findProductsACategory(anyString())).thenReturn(expectedProduct);

            List<Product> actualProduct = productService.getAllProductsACategory(category);

            assertEquals(expectedProduct,actualProduct);
        } catch (Exception exception) {
            fail(exception);
        }
    }


    @ParameterizedTest
    @MethodSource("argsGetAllCategory")
    void getAllCategory(List <String> expected) {
        try {
            assertNotNull(productDao);
            when(productDao.findAllCategories()).thenReturn(expected);

            List<String> actual = productService.getAllCategory();

            assertEquals(expected,actual);
        } catch (Exception exception) {
            fail(exception);
        }
    }
    @ParameterizedTest
    @MethodSource("argsSaveProduct")
    void saveProduct(Product product, Product expectedProduct) {
        try {
            assertNotNull(productDao);
            Mockito.when(productDao.save(Mockito.any(Product.class))).thenReturn(expectedProduct);

            Product resultProduct = productService.saveProduct(product);

            assertEquals(expectedProduct, resultProduct);
        } catch (Exception exception) {
            fail(exception);
        }
    }

    @ParameterizedTest
    @MethodSource("argsUpdateProduct")
    void updateProduct(Product product, Product expectedProduct) {
        try {
            assertNotNull(productDao);
            Mockito.when(productDao.save(Mockito.any(Product.class))).thenReturn(expectedProduct);

            Product resultProduct = productService.updateProduct(product);

            assertEquals(expectedProduct, resultProduct);
        } catch (Exception exception) {
            fail(exception);
        }
    }
}