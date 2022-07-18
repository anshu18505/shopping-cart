package com.SampleSpringProject1.project1.repository;

import com.SampleSpringProject1.project1.entity.ItemTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<ItemTable,Integer> {
//    ItemTable findByName(String item_name);
}
