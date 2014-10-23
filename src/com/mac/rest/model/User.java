package com.mac.rest.model;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id","firstName","lastName","age","employee","maritalStatus","address","phones","skills"})
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private boolean employee;
	private String maritalStatus;
	private Address address;
	private List<Phone> phones;
	private Set<String> skills;
	
	public User() {
	}

	public User(int id, String firstName, String lastName, int age,
			boolean employee, String maritalStatus, Address address,
			List<Phone> phones, Set<String> skills) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.employee = employee;
		this.maritalStatus = maritalStatus;
		this.address = address;
		this.phones = phones;
		this.skills = skills;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isEmployee() {
		return employee;
	}
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public Set<String> getSkills() {
		return skills;
	}
	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	
}
