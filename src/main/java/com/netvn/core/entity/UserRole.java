package com.netvn.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netvn.core.entity.User;
import com.netvn.core.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netvn.core.abstracts.AbstractEntity;

@Entity
@Table(name="user_role")
public class UserRole extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "role_id")
    @NotNull
    private Role role;
	
	public UserRole() {
	}
	    
	public UserRole(User user, Role role) {
		this.setUser(user);
		this.setRole(role);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
