package com.netvn.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.netvn.core.abstracts.AbstractEntity;

@Entity
@Table(name="users")
public class User extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	public boolean isEnabled() {
		return this.enabled;
	}
 
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Set<UserRole> roles = new HashSet<>();
	
	public User() {
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}
