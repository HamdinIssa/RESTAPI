package com.example.restapi.restapi.controller;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.service.ProductService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(path = "/api/products")
public class ProductsController {

    private ProductService productService;
    Logger LOG = (Logger) LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Product> getProduct(@PathVariable(name = "id") String id) {

        return productService.getProductService(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product saveProduct(@RequestBody Product productTosave) {

        return productService.saveProductService(productTosave);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody Product updatedProduct, @PathVariable(name = "id") String id) {

        return productService.updateProductService(updatedProduct, id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deletProduct(@PathVariable(name = "id") String id) {

        productService.deletProductService(id);
    }

}
