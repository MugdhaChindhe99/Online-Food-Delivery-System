
package com.cg.ofd.customer.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Create customer class as customer entity/table in database
@ApiModel(description = "Customer Model")


public class Customer {

	@Id
	@SequenceGenerator(name = "customer_id_sequence", initialValue = 2500, allocationSize = 1)
	@GeneratedValue(generator = "customer_id_sequence", strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(notes = "Id of the customer", name = "customerId", required = true, value = "123")
	private int customerId;

	@Column(length = 32)
	@NotNull(message = "first name can not be empty")
	@Size(min = 2, message = "First name must contain at least 2 characters")
	@ApiModelProperty(notes = "First Name of the customer", name = "firstName", required = true, value = "Emily")
	private String firstName;

	@ApiModelProperty(notes = " Last Name of the customer", name = "lastName", required = true, value = "Cooper")
	@Column(length = 32)
	@NotNull
	@Size(min = 2, message = "Last Name must contain at least 2 characters")
	private String lastName;

	@ApiModelProperty(notes = "Gender of the customer", name = "gender", required = true, value = "Female")
	@Column(length = 10)
	@NotEmpty(message = "Gender can not be empty")
	private String gender;

	@ApiModelProperty(notes = "Age of the customer", name = "age", required = true, value = "25")
	@Column(length = 10)
	@NotNull
	@Size(max = 3, message = "Age can not be more than 3 digits")
	private String age;

	@ApiModelProperty(notes = "Mobile Number of the customer", name = "mobileNumber", required = true, value = "7972361931")
	@Column(length = 32)
	@NotNull
	@Size(min=10, message = "Mobile must contain at least 10 digits")
	private String mobileNumber;

	@ApiModelProperty(notes = "Email of the customer", name = "email", required = true, value = "emily.cooper@gmail.com")
	@Column(length = 50)
	@Email
	@NotNull
	private String email;

	
	@NotNull(message="Address Field can not be empty")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	@Valid
	@NotNull(message="Address Field can not be empty")
	private Address address;

	
//	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinTable(name="Customer_Address",joinColumns = @JoinColumn(name="customerId"),
//			inverseJoinColumns = @JoinColumn(name="addressId"))
//	@Valid()
//	@NotNull(message="Address Field can not be empty")
//	private List<Address> address;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	
public Customer(int customerId,
		@NotNull(message = "first name can not be empty") @Size(min = 2, message = "First name must contain at least 2 characters") String firstName,
		@NotNull @Size(min = 2, message = "Last Name must contain at least 2 characters") String lastName,
		@NotEmpty(message = "Gender can not be empty") String gender,
		@NotNull @Size(max = 3, message = "Age can not be more than 3 digits") String age,
		@NotNull @Size(min = 10, message = "Mobile must contain at least 10 digits") String mobileNumber,
		@Email @NotNull String email, @Valid @NotNull(message = "Address Field can not be empty") Address address) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.age = age;
	this.mobileNumber = mobileNumber;
	this.email = email;
	this.address = address;
}




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
