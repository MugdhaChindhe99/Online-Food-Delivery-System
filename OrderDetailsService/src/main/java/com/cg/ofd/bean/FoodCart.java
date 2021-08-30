package com.cg.ofd.bean;

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

}
