package com.netvn.core.service;

import java.util.List;

import com.netvn.core.entity.Product;
import com.netvn.web.model.ProductDTO;

public interface ProductService {
	public Product saveOrUpdate(ProductDTO product) throws Exception;
	public List<Product> findAll();
	public Product findById(Long id);
	public Product delete(Long personId) throws Exception;
}
