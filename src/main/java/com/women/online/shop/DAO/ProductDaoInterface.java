package com.women.online.shop.DAO;

import com.women.online.shop.entities.Product;

import java.io.Serializable;
import java.util.List;

public interface ProductDaoInterface {
    public void persist(Product product);

    public void update(Product product);

    public Product findById(String id);

    public void delete(Product product);

    public List<Product> findAll();

    public void deleteAll();
}


