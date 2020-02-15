package com.isil.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="person")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="address")
	private String address;
	@Column(name="age")
	private String age;
	@Column(name="country")
	private String country;
	@Column(name="birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date birthDate;
	@Column(name="birth_day")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date birthday;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", address=" + address + ", age=" + age + ", country=" + country + ", birthDate=" + birthDate
				+ ", birthday=" + birthday + ", getId()=" + getId() + ", getName()=" + getName() + ", getCountry()="
				+ getCountry() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + ", getBirthDate()="
				+ getBirthDate() + ", getBirthday()=" + getBirthday() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
