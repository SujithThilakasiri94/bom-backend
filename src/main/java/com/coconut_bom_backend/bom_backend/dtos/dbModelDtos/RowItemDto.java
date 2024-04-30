package com.coconut_bom_backend.bom_backend.dtos.dbModelDtos;

import com.coconut_bom_backend.bom_backend.entities.AddedTo;

import java.util.List;

public class RowItemDto {
    private String name;
    private String description;
    private boolean isDisabled;
    private List<AddedTo> addedToList;
}
