package com.netvn.core.service;

import java.util.List;

import com.netvn.core.entity.Supplier;

public interface SupplierService {
	public List<Supplier> findAll();
	public Supplier findById(Long id);
}
