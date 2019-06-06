package com.baabbee.iframex.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "frm_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "user_remarks")
	private String remarks;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Embedded
	private Address address;
	
    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )	private Set<Role> roles;

	public User() {
		
	}
	/*
	public User(Long id, String name, Address address, Set<UserRequest> userRequests) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public User(Long id, String name, String emailId, String password, String mobile, String remarks, int active,
			Date createdDate, Date lastModifiedDate, Address address, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.mobile = mobile;
		this.remarks = remarks;
		this.active = active;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.address = address;
		this.roles = roles;
	}
	*/
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.emailId = user.getEmailId();
		this.password = user.getPassword();
		this.mobile = user.getMobile();
		this.remarks = user.getRemarks();
		this.active = user.getActive();
		this.createdDate = user.getCreatedDate();
		this.lastModifiedDate = user.getLastModifiedDate();
		this.address = user.getAddress();
		this.roles = user.getRoles();
	}
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + ", mobile=" + mobile + ", address="
				+ address + ", toString()=" + super.toString() + "]";
	}
	

}
