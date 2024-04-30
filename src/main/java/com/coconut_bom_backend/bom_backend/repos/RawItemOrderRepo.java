package com.coconut_bom_backend.bom_backend.repos;

import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RawItemOrderRepo extends JpaRepository<RowItemOrder,Integer> {
    @Query(value = "SELECT MAX(row_item_oder_id) FROM row_item_order", nativeQuery = true)
    Integer findLastIId();
}
