package com.coconut_bom_backend.bom_backend.controllers;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemOrderRequestDto;
import com.coconut_bom_backend.bom_backend.services.RowItemOderService;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/coconut-bom")
public class RowItemOrderController {

    private final RowItemOderService rowItemOderService;

    public RowItemOrderController(RowItemOderService rowItemOderService) {
        this.rowItemOderService = rowItemOderService;
    }

    @PostMapping("row-item-order/save")
    public StandardResponse addRowItemOrder(@RequestBody ArrayList<RowItemOrderRequestDto> dtoList){
        return rowItemOderService.SaveRowItemOrder(dtoList);
    }

}
