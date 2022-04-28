package com.pzz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
