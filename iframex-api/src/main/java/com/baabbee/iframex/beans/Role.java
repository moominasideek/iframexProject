package com.baabbee.iframex.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role")
	private String role;
	
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    
	public Role() {
		
	}

	public Role(int roleId, String role) {
		this.roleId = roleId;
		this.role = role;
	}

	public Role(int roleId, String role, Set<User> users) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.users = users;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUser() {
		return users;
	}

	public void setUser(Set<User> users) {
		this.users = users;
	}

	
}
