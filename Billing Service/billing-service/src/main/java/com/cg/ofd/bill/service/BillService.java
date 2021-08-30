/**
 * 
 */
package com.cg.ofd.bill.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ofd.bill.entities.Bill;
import com.cg.ofd.bill.entities.Items;

/**
 * @author abhinav
 * BillService Interface
 */
public interface BillService {
	
	public Bill addBill(Bill bill);
	public Bill updateBill(Bill bill);
	public boolean removeBill(int billId);
	//public Bill viewBill(Bill bill);
	//public List<Bill> viewBills(LocalDate startDate,LocalDate endDate);
	//public List<Bill> viewBills(String custId);
	public List<Bill> viewAllBills();
	public double calculateTotalCost(int orderId);
	
}
