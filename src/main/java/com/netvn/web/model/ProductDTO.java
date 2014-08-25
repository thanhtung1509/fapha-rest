package com.netvn.web.model;

public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Long supplier_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
}
