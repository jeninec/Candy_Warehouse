package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zip")
	private String zip;
	@Column(name="phone")
	private String phone;
	@Column(name="title")
	private String title;
	
	@OneToMany
	@JoinColumn(name="orderid")
	private List<Order> orderId;

	public Person() {
		super();
	}

	public Person(int id, String firstname, String lastname, String password, String email, String address1,
			String address2, String city, String state, String zip, String phone, String title, List<Order> orderId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.title = title;
		this.orderId = orderId;
	}

	public Person(String firstname, String lastname, String password, String email, String address1, String address2,
			String city, String state, String zip, String phone, String title, List<Order> orderId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.title = title;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Order> getOrderId() {
		return orderId;
	}

	public void setOrderId(List<Order> orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", title=" + title + ", orderId=" + orderId
				+ "]";
	}


	
	
}
