package com.myhospital.pathologyservices.models;

public class Disease {
private String Id;
private String name;
private String cure;
public Disease() {}
public Disease(String id, String name, String cure) {

	Id = id;
	this.name = name;
	this.cure = cure;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCure() {
	return cure;
}
public void setCure(String cure) {
	this.cure = cure;
}


}
