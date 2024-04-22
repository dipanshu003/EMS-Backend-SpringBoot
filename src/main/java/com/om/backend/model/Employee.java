package com.om.backend.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100, name = "name")
	private String name;
	@Column(length = 255, name = "designation")
	private String desg;
	@Column(length = 100, name = "status")
	private String status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_add_id")
	private Address address;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;

	@Temporal(TemporalType.DATE)
	private Date addedDate=new Date();

	public Employee() {
		super();
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Employee(int id, String name, String desg, String status, Address address, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.desg = desg;
		this.status = status;
		this.address = address;
		this.email = email;
		this.password = password;
		this.addedDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", desg=" + desg + ", status=" + status + ", address="
				+ address + ", email=" + email + ", password=" + password + ", addedDate=" + addedDate + "]";
	}

}
