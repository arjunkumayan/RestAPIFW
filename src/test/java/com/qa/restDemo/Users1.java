package com.qa.restDemo;

public class Users1 {
	
	String first_name;
     String last_name;
    String gender;
    String dob;
   String email;
    String phone;
    String address;
    String website;
    String status;
    
	public Users1(String first_name, String last_name, String gender, String dob, String email, String phone, String website,String address,
    String status) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.website=website;
		this.address=address;
		this.status=status;
	}
	public Users1() {
		
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getAddress() {
		return address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	
    
    

}
