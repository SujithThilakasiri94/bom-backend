package com.coconut_bom_backend.bom_backend.services;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemOrderRequestDto;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;

import java.util.List;


public interface RowItemOderService {
    StandardResponse SaveRowItemOrder(List<RowItemOrderRequestDto> dtoList);
}
