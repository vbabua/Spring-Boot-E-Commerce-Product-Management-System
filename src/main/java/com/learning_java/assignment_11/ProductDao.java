package com.learning_java.assignment_11;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao extends JpaRepository <Product,Integer>{

    @Query("select  DISTINCT c.name from Category c")
    public List<String> findAllCategories();

    @Query("select p from Product p inner join Category c on c.id=p.categoryId where c.name = :name")
    public List<Product> findProductsACategory(@Param("name")String categoryName);

}
