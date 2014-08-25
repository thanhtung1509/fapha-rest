package com.netvn.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netvn.core.service.ProductService;
import com.netvn.core.dao.ProductRepository;
import com.netvn.core.dao.SupplierRepository;
import com.netvn.core.entity.Product;
//import com.netvn.core.entity.Supplier;
import com.netvn.web.model.ProductDTO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Resource
    private ProductRepository productRepository;
	
	@Resource
	private SupplierRepository supplierRepository;
	
	@Override
	public Product saveOrUpdate(ProductDTO product) {
		/*Product entity = productRepository.findOne(product.getId());
		Supplier supplier = supplierRepository.findOne(product.getSupplier_id());
		
		if(entity == null) {
			entity = Product.getBuilder(product.getName(), product.getDescription(), supplier).build();
			productRepository.save(entity);
		} else {
			entity =  Product.getBuilder(product.getName(), product.getDescription(), supplier).build();
			productRepository.save(entity);
		}*/
		return null;//entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		List<Product> rs = productRepository.findAll();
		return rs;
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Product delete(Long id) throws Exception {
        LOGGER.debug("Deleting product with id: " + id);
        
        Product deleted = productRepository.findOne(id);
        
        if (deleted == null) {
            LOGGER.debug("No product found with id: " + id);
            throw new Exception();
        }
        
        productRepository.delete(deleted);
        return deleted;
	}

}
