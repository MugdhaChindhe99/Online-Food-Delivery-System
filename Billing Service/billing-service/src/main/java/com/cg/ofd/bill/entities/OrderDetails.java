package com.cg.ofd.bill.entities;

import java.time.LocalDate;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {

	@Id
	@SequenceGenerator(name = "order_id_sequence", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "order_id_sequence", strategy = GenerationType.SEQUENCE)
	private int orderId;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@NotNull
	private LocalDate orderDate;
	
	@NotNull
	@Column(length = 20)
	private String orderStatus;

	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name = "cartId")
	private FoodCart foodCart;

	
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", foodCart=" + foodCart + "]";
	}

//	public OrderDetails(int orderId, LocalDate orderDate, String orderStatus, FoodCart foodCart) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.orderStatus = orderStatus;
//		this.foodCart = foodCart;
//	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}

	
	
}
