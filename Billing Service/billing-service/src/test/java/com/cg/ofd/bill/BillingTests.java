package com.cg.ofd.bill;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.ofd.bill.entities.Bill;
import com.cg.ofd.bill.service.BillService;
import com.cg.ofd.bill.service.BillServiceImpl;

class BillingTests {

	static BillService billService = mock(BillServiceImpl.class);

	/*
	 * @Test void testAddBill() { Bill bill = new Bill(15, 10, 5, 120.0,
	 * LocalDate.now()); when(billService.addBill(bill)).thenReturn(bill);
	 * 
	 * Bill b2 = billService.addBill(bill); assertEquals(bill, b2); }
	 * 
	 * @Test void testRemoveBill() { Bill bill = new Bill(15, 10, 5, 120.0,
	 * LocalDate.now());
	 * when(billService.removeBill(bill.getBillId())).thenReturn(Boolean.TRUE);
	 * System.out.println(bill.getBillId()); boolean expected =
	 * billService.removeBill(15); assertEquals(Boolean.TRUE, expected); }
	 * 
	 * @Test void testViewBills() {
	 * 
	 * List<Bill> billsActual = new ArrayList<Bill>(); billsActual.add(new Bill(15,
	 * 10, 5, 120.0, LocalDate.now())); billsActual.add(new Bill(16, 20, 6, 220.0,
	 * LocalDate.now())); billsActual.add(new Bill(17, 5, 3, 50.0,
	 * LocalDate.now())); billsActual.add(new Bill(18, 8, 7, 150.0,
	 * LocalDate.now()));
	 * 
	 * when(billService.viewAllBills()).thenReturn(billsActual);
	 * System.out.println(billsActual); List<Bill> billsExpected =
	 * billService.viewAllBills(); System.out.println(billsExpected);
	 * assertEquals(billsActual, billsExpected); }
	 */
}
