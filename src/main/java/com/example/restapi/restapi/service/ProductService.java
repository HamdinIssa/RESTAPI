package com.example.restapi.restapi.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;

import ch.qos.logback.classic.Logger;

@Service
public class ProductService {

    private Logger LOG = (Logger) LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public Optional<Product> getProductService(String id) {

        LOG.info("Getting Product With Given ID ");
        Optional<Product> product = productRepository.findById(id);

        return product;
    }

    public Product saveProductService(Product productTosave) {

        try {
            LOG.info("Saving Product..................");
            return productRepository.save(productTosave);
        } catch (Exception e) {
            LOG.error("An error occured during product saving " + e.getMessage());
        }
        return new Product();

    }

    public Product updateProductService(Product updatedProduct, String id) {

        Product foundProduct = productRepository.getReferenceById(id);
        try {
            LOG.info("Updating Product..................");
            foundProduct.setName(updatedProduct.getName());
            foundProduct.setCategory(updatedProduct.getCategory());
            foundProduct.setDescription(updatedProduct.getDescription());
            foundProduct.setType(updatedProduct.getType());

            return productRepository.save(foundProduct);

        } catch (Exception e) {
            LOG.error("An error occured during update of product " + e.getMessage());
        }

        return updatedProduct;

    }

    public void deletProductService(String id) {
        try {
            LOG.error("deleting..............");

            productRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occured during deleting!!!!");
        }

    }

}
