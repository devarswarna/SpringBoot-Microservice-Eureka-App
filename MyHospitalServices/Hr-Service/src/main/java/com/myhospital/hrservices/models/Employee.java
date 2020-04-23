package com.myhospital.hrservices.models;

public class Employee {
private String Id;
private String firstname;
private String lastname;
private String desg;

public Employee() {}

public Employee(String id, String firstname, String lastname, String desg) {
	
	Id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.desg = desg;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
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

public String getDesg() {
	return desg;
}

public void setDesg(String desg) {
	this.desg = desg;
}


}
