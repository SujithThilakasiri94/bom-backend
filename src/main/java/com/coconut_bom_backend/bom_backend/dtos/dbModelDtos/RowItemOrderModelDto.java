package com.coconut_bom_backend.bom_backend.dtos.dbModelDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RowItemOrderModelDto {
    private LocalDate date;
    private double totalPrice;
    private LocalTime time;
}
