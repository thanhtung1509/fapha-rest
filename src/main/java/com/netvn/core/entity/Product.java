package com.netvn.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netvn.core.abstracts.AbstractEntity;

@Entity
@Table(name = "product")
public class Product extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="description")
	private String description;

	@JoinColumn(name="supplier_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;

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

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	public static Builder getBuilder(String name, String description, Supplier supplier) {
        return new Builder(name, description, supplier);
    }
	
	/**
     * A Builder class used to create new Product objects.
     */
    public static class Builder {
        Product built;

        /**
         * Create new Builder instance
         * @param name
         * @param description
         */
        Builder(String name, String description, Supplier supplier) {
            built = new Product();
            built.name = name;
            built.description = description;
            built.supplier = supplier;
        }

        /**
         * Builds the new Product object.
         * @return  The created Product object.
         */
        public Product build() {
            return built;
        }
    }
	
}
