package com.zp.dao;

import com.zp.entity.NoteType;

import java.util.List;

public interface NoteTypeDao {
    List<NoteType> findAll();
    Integer insert(NoteType noteType);
    Integer del(Integer id);
}
