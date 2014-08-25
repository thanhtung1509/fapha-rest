package com.netvn.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netvn.core.abstracts.AbstractEntity;

@Entity
@Table(name = "supplier")
public class Supplier extends AbstractEntity {
	
	@Column(name="name")
	@NotNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
