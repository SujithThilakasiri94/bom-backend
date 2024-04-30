package com.coconut_bom_backend.bom_backend.services;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemOrderRequestDto;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;

import java.util.ArrayList;

public interface RowItemOderService {
    StandardResponse SaveRowItemOrder(ArrayList<RowItemOrderRequestDto> dtoList);
}
