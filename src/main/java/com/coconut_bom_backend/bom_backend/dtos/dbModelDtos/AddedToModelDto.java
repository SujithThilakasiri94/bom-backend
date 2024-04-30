package com.coconut_bom_backend.bom_backend.dtos.dbModelDtos;

import com.coconut_bom_backend.bom_backend.entities.RowItemOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddedToModelDto {
    private int itemId;
    private RowItemOrder orderId;
    private double quantity;
    private double unitPrice;
}
