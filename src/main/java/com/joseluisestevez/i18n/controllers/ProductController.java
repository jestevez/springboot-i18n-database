package com.joseluisestevez.i18n.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.i18n.dto.ProductDto;
import com.joseluisestevez.i18n.models.entity.Product;
import com.joseluisestevez.i18n.service.ProductService;
import com.joseluisestevez.utils.dto.DtoUtils;

@RequestMapping("/products")
@RestController
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    private static final DtoUtils<ProductDto, Product> PRODUCTS_DTO_UTILS = new DtoUtils<>(ProductDto.class,
	    Product.class);

    @GetMapping("i18n/{id}")
    public ProductDto viewI18n(@PathVariable Long id) {
	Locale currentLocale = LocaleContextHolder.getLocale();
	LOGGER.info("currentLocale [{}]", currentLocale);
	Product product = productService.findById(id);
	return PRODUCTS_DTO_UTILS.convertToDto(product);
    }

    @GetMapping
    public List<Product> list() {
	return productService.findAll();
    }

    @GetMapping("{id}")
    public Product view(@PathVariable Long id) {
	return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
	return productService.save(product);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product edit(@RequestBody Product product, @PathVariable Long id) {
	Product productBD = productService.findById(id);
	productBD.setName(product.getName());
	productBD.setPrice(product.getPrice());
	return productService.save(productBD);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
	productService.deleteById(id);
    }
}
