package com.cg.ofd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.cg.ofd.bean.Items;

@Repository
public interface ItemDao extends JpaRepository<Items, Integer> {

}
