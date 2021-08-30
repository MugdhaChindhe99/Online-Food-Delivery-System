package com.cg.ofd.bill.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@Entity
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="Customer Model")
public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id_sequence", initialValue = 2500, allocationSize = 1)
	@GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(notes="Id of the customer", name="customerId",required=true,value="123")
	private int customerId;
	
	@Column(length = 32)
	@ApiModelProperty(notes="First Name of the customer", name="firstName",required=true,value="Emily")
	private String firstName;
	
	@ApiModelProperty(notes=" Last Name of the customer", name="lastName",required=true,value="Cooper")
	@Column(length = 32)
	private String lastName;
	
	@ApiModelProperty(notes="Gender of the customer", name="gender",required=true,value="Female")
	@Column(length = 10)
	private String gender;
	
	@ApiModelProperty(notes="Age of the customer", name="age",required=true,value="25")
	@Column(length = 10)
	private String age;
	
	@ApiModelProperty(notes="Mobile Number of the customer", name="mobileNumber",required=true,value="7972361931")
	@Column(length = 32)
	private String mobileNumber;
	
	@ApiModelProperty(notes="Email of the customer", name="email",required=true,value="emily.cooper@gmail.com")
	@Column(length = 50)
	private String email;

	@OneToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name = "addressId")
	private Address address;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
