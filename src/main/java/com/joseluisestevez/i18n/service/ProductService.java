package com.joseluisestevez.i18n.service;

import java.util.List;

import com.joseluisestevez.i18n.models.entity.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}