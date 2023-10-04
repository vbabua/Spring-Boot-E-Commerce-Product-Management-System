package com.learning_java.assignment_11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    static Stream<Arguments> argsAllProducts() {
        Product product = new Product(5,"CloseUp paste", new BigDecimal(55),2);
        List <Product> allProducts = Collections.singletonList(product);
        return Stream.of(
                arguments(allProducts)
        );
    }

    static Stream<Arguments> argsAllCategories() {
        String  category = new String("Electronics");
        List <String> allCategories = Collections.singletonList(category);
        return Stream.of(
                arguments(allCategories)
        );
    }

    static Stream<Arguments> argsFindProductsByCategory() {
        Product product = new Product(5,"CloseUp paste", new BigDecimal(55),2);
        List <Product> allProducts = Collections.singletonList(product);
        return Stream.of(
                arguments(allProducts)
        );
    }

    @ParameterizedTest
    @MethodSource("argsAllProducts")
    void allProducts(List <Product> expectedListOfProducts) throws Exception {
       Mockito.when(productService.getProducts()).thenReturn(expectedListOfProducts);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        assertThat(convertToJson(expectedListOfProducts)).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    @ParameterizedTest
    @MethodSource("argsFindProductsByCategory")
    void findProductsByCategory(List <Product> expectedProductList) throws Exception {
        Mockito.when(productService.getAllProductsACategory(Mockito.anyString())).thenReturn(expectedProductList);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/product/Personal Care").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        assertThat(convertToJson(expectedProductList)).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    @ParameterizedTest()
    @MethodSource("argsAllCategories")
    void allCategories(List <String> expectedList) throws Exception {
        Mockito.when(productService.getAllCategory()).thenReturn(expectedList);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/categories").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();

        assertThat(convertToJson(expectedList)).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void addProduct() throws Exception{
        Product product = new Product(5,"Colgate",new BigDecimal(55),2);

        Mockito.when(productService.saveProduct(Mockito.any(Product.class))).thenReturn(product);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post("/product").accept(MediaType.APPLICATION_JSON).content(convertToJson(product)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        assertThat(convertToJson(product)).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void updateProduct() throws Exception{
        Product product = new Product(5,"Colgate Paste",new BigDecimal(55),2);

        Mockito.when(productService.updateProduct(Mockito.any(Product.class))).thenReturn(product);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.put("/product").accept(MediaType.APPLICATION_JSON).content(convertToJson(product)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

        assertThat(convertToJson(product)).isEqualTo(mvcResult.getResponse().getContentAsString());
    }

    /**
     * Convert Object into Json String by using Jackson ObjectMapper
     * @param product
     * @return return a string of json value of the object passed
     * @throws JsonProcessingException
     */
    private String convertToJson(Object product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }
}