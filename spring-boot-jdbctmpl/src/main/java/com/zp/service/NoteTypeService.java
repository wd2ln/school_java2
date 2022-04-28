package com.zp.service;

import com.zp.entity.NoteType;

import java.util.List;

public interface NoteTypeService {
    List<NoteType> findAll();
    Integer insert(NoteType noteType);
    Integer del(Integer id);
}
