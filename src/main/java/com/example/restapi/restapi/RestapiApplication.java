package com.example.restapi.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.restapi.restapi.model.Product;
import com.example.restapi.restapi.repository.ProductRepository;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner{

	private ProductRepository productRepository;
	
	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product testProduct = new Product();

		testProduct.setName("book");
		testProduct.setCategory("culture");
		testProduct.setDescription("set of papers");
		testProduct.setType("private");

		productRepository.save(testProduct);
	}



}
