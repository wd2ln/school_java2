package com.pzz.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MapAndList {
    private List<User> Slist;
    private Map<String,User> Mstr;
}
