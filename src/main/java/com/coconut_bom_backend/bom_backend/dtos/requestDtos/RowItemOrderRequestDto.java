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
    private int rowItemId;
    private double quantity;
    private double unitPrice;
}
