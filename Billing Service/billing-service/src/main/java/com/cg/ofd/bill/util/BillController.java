/**
 * 
 */
package com.cg.ofd.bill.util;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofd.bill.entities.Bill;
import com.cg.ofd.bill.entities.OrderDetails;
import com.cg.ofd.bill.exception.BillNotFoundException;
import com.cg.ofd.bill.proxies.OrderServiceProxy;
import com.cg.ofd.bill.service.BillService;

/**
 * @author abhinav BillController.java
 * 
 *
 */

@RestController
//@RibbonClient(name="BillManagement")
public class BillController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private OrderServiceProxy orderProxy;

	private static final Logger logger = LoggerFactory.getLogger(BillController.class);

	@PostMapping("/bill/addBill/{orderId}")
	public void addBill(@RequestBody Bill bill, @PathVariable int orderId) {
		logger.info("Inside addBill() method of BillController");
		
		OrderDetails order = orderProxy.findOrdersByOrderId(orderId);
		bill.setBillDate(orderProxy.findOrdersByOrderId(orderId).getOrderDate());
		bill.setOrder(order);
		bill.setTotalItem(order.getFoodCart().getItemList().size());
		bill.setTotalCost(billService.calculateTotalCost(orderId));
		
		if (bill.getOrder() == null && bill.getBillDate() == null && bill.getTotalItem() == 0)
			throw new BillNotFoundException("Can not add empty bill!!");
		else if(bill.getOrder() == null || bill.getBillDate() == null || bill.getTotalItem() == 0)
			throw new BillNotFoundException("Bill is invalid!!");
		else {
			billService.addBill(bill);
			System.out.println("Bill with Bill Id: " + bill.getBillId() + " added succesfully to the database!");
		}
	}

	@PutMapping("/bill/update")
	public void updateBill(@RequestBody Bill bill) {
		logger.info("Inside updateBill() method of BillController");
		billService.updateBill(bill);
	}

	@DeleteMapping("/bill/remove/{billId}")
	public void removeBill(@PathVariable int billId) {
		logger.info("Inside removeBill() method of BillController");

		Bill bill = billService.viewAllBills().stream().filter(id -> id.getBillId() == billId).findAny().get();
		if (bill == null)
			throw new BillNotFoundException("Bill with Bill Id: " + billId + " already does not exist!!");
		else {
			billService.removeBill(billId);
			System.out.println("Bill with Bill Id: " + billId + " removed succesfully from the database!");
		}

	}

	@GetMapping("/bill/allBills")
	public List<Bill> viewAllBills() {
		System.out.println("Inside ViewAllBills() method of BillController");
		List<Bill> bills = billService.viewAllBills();
		if (bills.isEmpty())
			throw new BillNotFoundException("Bills not Found");
		else
			return bills;
	}

	@GetMapping("/bill/viewBill/{billId}")
	public Bill viewBill(@PathVariable int billId) {
		logger.info("Inside viewBill() method of BillController");

		Bill bill = billService.viewAllBills().stream().filter(id -> id.getBillId() == billId).findAny().get();
		if (bill.equals(null))
			throw new BillNotFoundException("Bill with Bill Id: " + billId + " not found!!");

		return bill;
	}

	@GetMapping("/bill/viewBillsByDate/{startDate}/to/{endDate}")
	public List<Bill> viewBills(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

		logger.info("Inside viewBills(startDate, endDate) method of BillController");

		if ((startDate.compareTo(endDate)) > 0) {
			throw new BillNotFoundException("Invalid Date Selection, Bills Not Found!!");
		} else {
			
				List<Bill> billsByDate = billService.viewAllBills().stream()
						.filter((bills) -> bills.getBillDate().isAfter(startDate.minusDays(1))
								&& bills.getBillDate().isBefore(endDate.plusDays(1)))
						.collect(Collectors.toList());
				
				if(billsByDate.isEmpty()) {
					throw new BillNotFoundException("Bills Not Found!!");
			}
			return billsByDate;
		}

	}

	@GetMapping("/bill/viewCustBills/{custId}")
	public List<Bill> viewBills(@PathVariable int custId) {
		logger.info("Inside viewBills(custId) method of BillController");
		System.out.println(custId);
		
		//List<OrderDetails> orders = orderProxy.findOrdersByCustomer(custId);
		List<Bill> bills = billService.viewAllBills().stream().filter(id -> id.getOrder().getFoodCart().getCustomer().getCustomerId() == custId).collect(Collectors.toList());
		if (bills.equals(null))
			throw new BillNotFoundException("Bills with Cust Id: " + custId + " not found!!");

		return bills;
	}

}
