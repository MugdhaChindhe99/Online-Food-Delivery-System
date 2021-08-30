/** 
 * @author:pragya
  
 */
package com.cg.ofd.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.customer.bean.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{



}
