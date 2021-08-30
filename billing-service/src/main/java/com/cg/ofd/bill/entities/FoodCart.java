package com.cg.ofd.bill.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodCart {

	@Id
	@SequenceGenerator(name = "cart_id_sequence", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "cart_id_sequence", strategy = GenerationType.SEQUENCE)
	private int cartId;
	
	@NotNull
	private int itemQuantity;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "customerId")
	private Customer customer;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Cart_Items", joinColumns = @JoinColumn(name = "cartId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
	List<Items> itemList;

//	public FoodCart(int cartId, int itemQuantity, Customer customer, List<Items> itemList) {
//		super();
//		this.cartId = cartId;
//		this.itemQuantity = itemQuantity;
//		this.customer = customer;
//		this.itemList = itemList;
//	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "FoodCart [cartId=" + cartId + ", itemQuantity=" + itemQuantity + ", customer=" + customer
				+ ", itemList=" + itemList + "]";
	}
	
	

}
