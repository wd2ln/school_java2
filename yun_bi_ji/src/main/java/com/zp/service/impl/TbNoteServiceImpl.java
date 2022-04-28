package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.TbNoteMapper;
import com.zp.entity.TbNote;
import com.zp.entity.TbNoteExample;
import com.zp.entity.TbUserExample;
import com.zp.service.TbNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbNoteServiceImpl implements TbNoteService {
    @Autowired
    private TbNoteMapper tbNoteMapper;
    @Override
    public Map<String,Object> getDates(TbNote tbNote, Integer pageNum, Integer pageSize) {
        //设置查询所需的参数
        TbNoteExample tbNoteExample = new TbNoteExample();
        TbNoteExample.Criteria criteria = tbNoteExample.createCriteria();
        criteria.andTypeIdEqualTo((tbNote.getTypeId()));
        //设置分页
        PageHelper.offsetPage(pageNum,pageSize);
        //获取查询结果
        List<TbNote> tbNotes = tbNoteMapper.selectByExample(tbNoteExample);
        Map<String, Object> map =null;
        //有数据
        if (tbNotes!=null){
            //将分页结果放入
            PageInfo<TbNote> tbNotePageInfo = new PageInfo<>(tbNotes);
            map=new HashMap<String, Object>();
            map.put("pageinfo",tbNotePageInfo);
            map.put("total",tbNotePageInfo.getTotal());
        }
        return map;
    }

    @Override
    public Map<String, Object> getDateInfo(TbNote tbNote, Integer pageNum, Integer pageSize) {
        //设置查询所需的参数
        TbNoteExample tbNoteExample = new TbNoteExample();
        tbNoteExample.createCriteria()
            .andTypeIdEqualTo((tbNote.getTypeId()));
        //tbNoteMapper.selectByExampleWithBLOBs()
        return null;
    }

    @Override
    public Map<String, Object> getDateType(Integer id) {
        //设置查询所需的参数


        return null;
    }
}
