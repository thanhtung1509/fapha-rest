package com.netvn.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netvn.core.dao.SupplierRepository;
import com.netvn.core.entity.Supplier;
import com.netvn.core.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Resource
	SupplierRepository supplier;
	
	@Override
	public List<Supplier> findAll() {
		return supplier.findAll();
	}

	@Override
	public Supplier findById(Long id) {
		return supplier.findOne(id);
	}

}
