package com.coconut_bom_backend.bom_backend.repos;

import com.coconut_bom_backend.bom_backend.entities.AddedTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepo extends JpaRepository<AddedTo,Integer> {
}
