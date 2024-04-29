package com.coconut_bom_backend.bom_backend.repos;

import com.coconut_bom_backend.bom_backend.entities.RowItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowItemRepo extends JpaRepository<RowItem,Integer> {
    RowItem findByName(String name);
}
