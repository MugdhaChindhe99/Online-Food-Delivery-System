package com.cg.ofd.bill.entities;

import java.time.LocalDate;

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
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
//@Table(name = "Bill")
public class Bill {
	
	@Id
	@SequenceGenerator(name = "order_id_sequence", initialValue = 600, allocationSize = 1)
	@GeneratedValue(generator = "order_id_sequence", strategy = GenerationType.SEQUENCE)
	private int billId;
	
//	@Column
	@OneToOne(fetch = FetchType.EAGER, cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name = "orderId")
	private OrderDetails order;
	
	@Column
	@NotNull
	@Min(value = 1)
	private int totalItem;
	
	@Column
	@NotNull
	private double totalCost;
	
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = "billDate")
	@NotNull
	private LocalDate billDate;

	/**
	 * 
	 */
	public Bill() {
		
	}

	/**
	 * @param billId
	 * @param orderId
	 * @param totalItem
	 * @param totalCost
	 * @param billDate
	 */
	public Bill(int billId, OrderDetails order, int totalItem, double totalCost, LocalDate billDate) {
		super();
		this.billId = billId;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.billDate = billDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", order=" + order + ", totalItem=" + totalItem + ", totalCost=" + totalCost
				+ ", billDate=" + billDate + "]";
	}
	
		
}
