package Dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Customerdto {
@Id
@GeneratedValue(generator="idg")
@SequenceGenerator(initialValue=4512131,allocationSize=1,name="idg",sequenceName="idg")
	int customerid;
	String name;
	String email;
	String password;
	long mobile;
	String gender;
	Date dob;
	String address;
	int age;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customerdto [customerid=" + customerid + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", gender=" + gender + ", dob=" + dob + ", address=" + address
				+ ", age=" + age + "]";
	}
	
}
