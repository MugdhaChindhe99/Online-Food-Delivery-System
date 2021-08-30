package com.cg.ofd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.FoodCart;

@Repository
public interface FoodCartDao extends JpaRepository<FoodCart, Integer> {
	
	/*
	 * @Query("select fc from FoodCart fc where customer.customerId =:customerId")
	 * public List<FoodCart> viewCartByCustId(int customerId);
	 */
	
//	@Modifying
//	@Query("DELETE FROM FoodCart fc WHERE fc.cartId=:cartId and fc.itemId=:itemId")
//	@Transactional
//	void removeItem(@Param("cartId") int cartId, @Param("itemId") int itemId);
//
//	@Modifying
//	@Query("SELECT fc FROM FoodCart fc WHERE fc.cartId=:cartId and fc.itemId=:itemId")
//	@Transactional
//	List<Item> getAllItemsByCartIdItemId(int cartId, int itemId);

	/*
	 * @Query("UPDATE FoodCart fc SET fc.quantity=:quantity WHERE fc.cartId=:cartId and fc.itemId=:itemId"
	 * )
	 * 
	 * @Transactional void updateItemInCart(@Param("cartId") int
	 * cartId, @Param("itemId") String itemId , @Param("quantity") int quantity);
	 */
}
