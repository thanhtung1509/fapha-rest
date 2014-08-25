package com.netvn.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.netvn.core.enums.RoleType;
import com.netvn.core.abstracts.AbstractEntity;

@Entity
@Table(name="role")
public class Role extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Transient
    private RoleType type;
	
	public Role() {
    }
    
    public Role(String roleId){
        this.setId(roleId);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleType getType() {
		RoleType roleType = RoleType.getById(Integer.parseInt(getId()));
    	if (roleType == null) {
    		roleType = RoleType.USER;
    	}
		return roleType;
	}

	public void setType(RoleType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
