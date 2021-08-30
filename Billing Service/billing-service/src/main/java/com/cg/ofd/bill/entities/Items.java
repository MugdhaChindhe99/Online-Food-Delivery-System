package com.cg.ofd.bill.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
public class Items {

	@Id
	@SequenceGenerator(name = "items_id_sequence", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "items_id_sequence", strategy = GenerationType.SEQUENCE)
	private int itemId;
	
	
	 @Size(min=2, message="Name should have atleast 2 characters")
	@Column(length=20)
	private String itemName;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId",foreignKey = @ForeignKey(name = "FK_category"))
	private Category category;
	
	@Min(value=1,message="min 1 quantity should be present")
	@Column(length=20)
	private int quantity;
	
	
	@DecimalMax("1000.0") @DecimalMin("0.0") 
	@Column(length=20)
	private double cost;
	
	@ManyToMany(mappedBy = "item",fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REFRESH}) 
	@JsonIgnoreProperties("item")
	 List<Restaurant> restaurant;

	public Items(int itemId, @Size(min = 2, message = "Name should have atleast 2 characters") String itemName,
			Category category, @Min(value = 2, message = "min 2 digit number") int quantity,
			@DecimalMax("1000.0") @DecimalMin("0.0") double cost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity="
				+ quantity + ", cost=" + cost + ", restaurant=" + restaurant + "]";
	}
	
}
