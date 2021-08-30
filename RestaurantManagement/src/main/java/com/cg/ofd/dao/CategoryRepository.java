package com.cg.ofd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ofd.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
