package com.coconut_bom_backend.bom_backend.repos;

import com.coconut_bom_backend.bom_backend.entities.RawItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowItemRepo extends JpaRepository<RawItem,Integer> {
}
