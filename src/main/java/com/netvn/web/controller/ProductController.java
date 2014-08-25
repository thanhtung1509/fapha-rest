package com.netvn.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netvn.core.entity.Product;
import com.netvn.core.service.ProductService;
import com.netvn.web.model.ProductDTO;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productSrv;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	@ResponseBody List<Product> getAll() {
		LOGGER.debug("Get list product ");
		return productSrv.findAll();
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	@ResponseBody Product saveOrUpdate(@RequestBody ProductDTO product) {
		Product rs;
		try {
			rs = productSrv.saveOrUpdate(product);
		} catch(Exception e) {
			rs = null;
		}
		return rs;
	}
}
