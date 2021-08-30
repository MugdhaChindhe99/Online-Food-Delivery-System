/**
 * 
 */
package com.cg.ofd.bill.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofd.bill.dao.BillRepository;
import com.cg.ofd.bill.entities.Bill;
import com.cg.ofd.bill.entities.FoodCart;
import com.cg.ofd.bill.entities.Items;
import com.cg.ofd.bill.entities.OrderDetails;
import com.cg.ofd.bill.proxies.OrderServiceProxy;

/**
 * @author abhin
 * BillService Implementation
 * 
 */
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private OrderServiceProxy orderProxy;

	@Override
	public Bill addBill(Bill bill) {
		System.out.println("Inside addBill() method");
		return this.billRepository.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) {
		System.out.println("Inside updateBill() method");
		return this.billRepository.save(bill);
	}

	@Override
	public boolean removeBill(int billId) {
		System.out.println("Inside removeBill() method");
		billRepository.deleteById(billId);
		return true;
	}

	@Override
	public List<Bill> viewAllBills() {
		System.out.println("Inside ViewAllBills() method");
		return billRepository.findAll();
	}

	@Override
	public double calculateTotalCost(int orderId) {
		
		FoodCart foodCart = orderProxy.findOrdersByOrderId(orderId).getFoodCart();
		double total = 0;
//		for (Items ip : foodCart.getItemList()) {
//	        total += ip.getCost()*ip.getQuantity(); //remaining quantity * krra
//	    }
		for (Items ip : foodCart.getItemList()) {
			
	        total += ip.getCost()*foodCart.getItemQuantity();//totl itemquantity no of items baar krra 
	    }
		return total;
	}

}
