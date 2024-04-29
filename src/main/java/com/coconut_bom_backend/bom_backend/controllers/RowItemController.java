package com.coconut_bom_backend.bom_backend.controllers;

import com.coconut_bom_backend.bom_backend.dtos.requestDtos.RowItemRequestDto;
import com.coconut_bom_backend.bom_backend.services.impls.RowItemServiceImpl;
import com.coconut_bom_backend.bom_backend.util.StandardResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/coconut-bom")
public class RowItemController {

    private final RowItemServiceImpl rowItemService;

    public RowItemController(RowItemServiceImpl rowItemService) {
        this.rowItemService = rowItemService;
    }

    @PostMapping("row-item/save")
    public StandardResponse saveRowItem(@RequestBody RowItemRequestDto dto){
        return rowItemService.saveRowItem(dto);
    }
}
