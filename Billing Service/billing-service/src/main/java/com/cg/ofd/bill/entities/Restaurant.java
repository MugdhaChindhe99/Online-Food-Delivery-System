package com.cg.ofd.bill.entities;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

	@Id
	@SequenceGenerator(name = "restaurant_id_sequence", initialValue = 100000, allocationSize = 1)
	  @GeneratedValue(generator = "restaurant_id_sequence", strategy = GenerationType.SEQUENCE)
	private int restaurantId;
	
	 @NotNull
	 @Size(min=2, message="Name should have atleast 2 characters")
	@Column(length = 20)
	private String restaurantName;
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinColumn(name = "addressId")
	@Valid
	private Address address;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="Restro_Items",joinColumns = @JoinColumn(name="restaurantId"),
			inverseJoinColumns = @JoinColumn(name="itemId"))
	public List<Items> item;
	
	 @NotNull
	 @Size(min=2, message="ManagerName should have atleast 2 characters")
	@Column(length = 20)
	private String managerName;
	
	 @NotNull
	@Size(min=10, message="Contactno should have atleast 10 digits")
	@Column(length = 20)
	private String contactNo;

	public Restaurant(int restaurantId,
			@Size(min = 2, message = "Name should have atleast 2 characters") String restaurantName, Address address,
			@Size(min = 2, message = "ManagerName should have atleast 2 characters") String managerName,
			@Size(min = 10, message = "Contactno should have atleast 10 digits") String contactNo) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.managerName = managerName;
		this.contactNo = contactNo;
	}
	
	 

}
