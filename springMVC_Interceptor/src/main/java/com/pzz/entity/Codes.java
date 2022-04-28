package com.pzz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Codes {
    private Integer code;
    private String message;
    private Boolean success;
    private Object data;
}
