package com.coconut_bom_backend.bom_backend.dtos.requestDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RowItemOrderRequestDto {
    private int itemId;
    private int orderId;
    private double qty;
    private double unitPrice;
}
