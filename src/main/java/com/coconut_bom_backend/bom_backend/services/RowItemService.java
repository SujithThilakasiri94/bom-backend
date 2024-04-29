package com.coconut_bom_backend.bom_backend.services;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemRequestDto;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;

public interface RowItemService {
    StandardResponse saveRowItem(RowItemRequestDto dto);
}
