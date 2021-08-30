/** 
 * @author:pragya
  
 */
package com.cg.ofd.customer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Address Model")
public class Address {

	@Id
	@SequenceGenerator(name = "address_id_sequence", initialValue = 529, allocationSize = 1)
	@GeneratedValue(generator= "address_id_sequence",strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(notes = "Address ID of the customer", name = "addressId", required = true, value = "201")
	private int addressId;

	@ApiModelProperty(notes = "Building Name of the Customer's Address", name = "buildingName", required = true, value = "Stark Tower")
	@Column(length = 32)
	@NotEmpty(message = "Building Name can not be empty")
	private String buildingName;

	@ApiModelProperty(notes = "Area of the customer", name = "area", required = true, value = "Pimpri")
	@Column(length = 32)
	@NotEmpty(message = "Area can not be empty")
	private String area;

	@ApiModelProperty(notes = "Street Number of the customer", name = "streetNo", required = true, value = "Lane 32")
	@Column(length = 32)
	@NotEmpty(message = "Street Number can not be empty")
	private String streetNo;

	@ApiModelProperty(notes = "City of the customer", name = "city", required = true, value = "Pune")
	@Column(length = 32)
	@NotNull
	@Size(min = 2, message = "City must contain at least 2 characters")
	private String city;

	@ApiModelProperty(notes = "State of the customer", name = "state", required = true, value = "Maharashtra")
	@Column(length = 32)
	@NotNull
	@Size(min = 3, message = "State must contain at least 3 characters")
	private String state;

	@ApiModelProperty(notes = "Country of the customer", name = "country", required = true, value = "India")
	@Column(length = 32)
	@NotNull
	@Size(min = 3, message = "Country must contain at least 3 characters")
	private String country;

	@ApiModelProperty(notes = "Pincode of the customer", name = "pincode", required = true, value = "411045")
	@Column(length = 32)
	@NotNull
	@Size(min = 6, message = "Pincode must contain at least 6 digits")
	private String pincode;

	public Address() {

	}

	public Address(int addressId, @NotEmpty(message = "Building Name can not be empty") String buildingName,
			@NotEmpty(message = "Area can not be empty") String area,
			@NotEmpty(message = "Street Number can not be empty") String streetNo,
			@NotNull @Size(min = 2, message = "City must contain at least 2 characters") String city,
			@NotNull @Size(min = 3, message = "State must contain at least 3 characters") String state,
			@NotNull @Size(min = 3, message = "Country must contain at least 3 characters") String country,
			@NotNull @Size(min = 6, message = "Pincode must contain at least 6 digits") String pincode) {
		super();
		this.addressId = addressId;
		this.buildingName = buildingName;
		this.area = area;
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
