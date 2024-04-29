package com.coconut_bom_backend.bom_backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
