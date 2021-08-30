package com.cg.ofd.bill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bill.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
