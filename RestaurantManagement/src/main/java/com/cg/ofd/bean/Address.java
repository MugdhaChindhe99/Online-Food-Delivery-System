package com.cg.ofd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@SequenceGenerator(name = "address_id_sequence", initialValue = 529, allocationSize = 1)
	  @GeneratedValue(generator = "address_id_sequence", strategy = GenerationType.SEQUENCE)
	private int addressId;
	
	@NotNull
	@Size(min=2,message="Building name should be of atlesst 2 characters")
	@Column(length = 20)
	private String buildingName;
		
	@NotNull
	@Size(min=2,message="Street no should be of atlesst 2 characters")
	@Column(length = 20)
	private String streetNo;
		
	@NotNull
	@Size(min=2,message="Area should be of atlesst 2 characters")
	@Column(length = 20)
	private String area;
		
	@NotNull
	@Size(min=2,message="City should be of atlesst 2 characters")
	@Column(length = 20)
	private String city;
		
	@NotNull
	@Size(min=2,message="State should be of atlesst 2 characterss")
	@Column(length = 20)
	private String state;
		 
	@NotNull
	@Size(min=2,message="Country should be of atlesst 2 characters")
	@Column(length = 20)
	private String country;
	
	@NotNull
	@Size(min=6,message="Pincode must contain at least 6 digits")
	@Column(length = 20)
	private String pincode;
	
}
