package com.coconut_bom_backend.bom_backend.dtos.dbModelDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddedToModelDto {

    private int itemId;
    private int orderId;
    private double quantity;
    private double unitPrice;
}
