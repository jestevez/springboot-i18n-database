package com.joseluisestevez.i18n.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.i18n.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}