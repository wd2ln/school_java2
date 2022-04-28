package com.zp.service.impl;

import com.zp.dao.NoteTypeDao;
import com.zp.entity.NoteType;
import com.zp.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeDao noteTypeDao;
    @Override
    public List<NoteType> findAll() {
        return noteTypeDao.findAll();
    }

    @Override
    public Integer insert(NoteType noteType) {
        return noteTypeDao.insert(noteType);
    }

    @Override
    public Integer del(Integer id) {
        return noteTypeDao.del(id);
    }
}
