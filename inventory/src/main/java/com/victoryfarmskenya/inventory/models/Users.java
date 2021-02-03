package com.victoryfarmskenya.inventory.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames="email"))
@Inheritance(strategy =InheritanceType.JOINED)
public @Data class  Users implements UserDetails{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
    private String email;
	@Column(nullable = false)
    private String password;
	@Column(nullable = false)
    private String names;
	@Column(nullable = false)
    private String role;
	public Users(String email) {
		this.email=email;
	}
	public Users() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.createAuthorityList(this.role);
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password; 
	}
	public String getEmail() {
		return this.email;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	
}