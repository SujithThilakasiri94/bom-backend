package com.coconut_bom_backend.bom_backend.repos;

import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawItemOrderRepo extends JpaRepository<RowItemOrder,Integer> {
}
