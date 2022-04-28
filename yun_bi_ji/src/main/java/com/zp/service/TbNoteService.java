package com.zp.service;

import com.zp.entity.TbNote;

import java.util.List;
import java.util.Map;

public interface TbNoteService {

    Map<String,Object> getDates(TbNote tbNote, Integer pageNum, Integer pageSize);

    Map<String,Object> getDateInfo(TbNote tbNote, Integer pageNum, Integer pageSize);

    Map<String,Object> getDateType(Integer id);
}
