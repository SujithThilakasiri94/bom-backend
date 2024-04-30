package com.coconut_bom_backend.bom_backend.dtos.requestDtos;

import com.coconut_bom_backend.bom_backend.entities.RowItem;
import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RowItemOrderRequestDto {
    private int rowItemId;
    private double quantity;
    private double unitPrice;
}
