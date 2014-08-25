package com.netvn.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.netvn.core.entity.User;
import com.netvn.core.entity.UserRole;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	public SecurityUser(User user) {
		if(user != null)
		{
			this.setId(user.getId());
			this.setName(user.getName());
			//this.setEmail(user.getEmail());
			this.setPassword(user.getPassword());
			this.setRoles(user.getRoles());
		}		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<UserRole> userRoles = this.getRoles();
		
		if(userRoles != null)
		{
			for (UserRole role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().getName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
