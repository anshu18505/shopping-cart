package com.demo3.demo3.repo;

import com.demo3.demo3.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.event.ItemListener;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
