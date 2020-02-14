package com.joseluisestevez.i18n.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.i18n.models.dao.ProductDao;
import com.joseluisestevez.i18n.models.entity.Product;
import com.joseluisestevez.i18n.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
	return (List<Product>) productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
	return productDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {
	return productDao.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
	productDao.deleteById(id);
    }

}