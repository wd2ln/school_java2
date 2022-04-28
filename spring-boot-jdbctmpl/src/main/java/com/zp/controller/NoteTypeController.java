package com.zp.controller;

import com.zp.entity.NoteType;
import com.zp.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("note")
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;
    @RequestMapping("findall")
    public List<NoteType> findall(){
        return noteTypeService.findAll();
    }
    @RequestMapping("insert")
    public Integer inserts(@RequestBody NoteType noteType){
        return noteTypeService.insert(noteType);
    }
    @RequestMapping("del")
    public Integer del(Integer id){
        return noteTypeService.del(id);
    }
}
