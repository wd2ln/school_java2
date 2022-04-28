package com.zp.service.impl;

import com.zp.dao.TbMusicMapper;
import com.zp.dao.TbSheetMapper;
import com.zp.entity.TbMusic;
import com.zp.entity.TbMusicExample;
import com.zp.entity.TbSheet;
import com.zp.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;
    @Autowired
    private TbMusicMapper tbMusicMapper;
    @Override
    public List<TbSheet> findAll() {
        return tbSheetMapper.selectByExample(null);
    }

   /* @Override
    public List<TbMusic> findBySheet(Integer sheetId) {
        //获取歌单id
        TbSheet tbSheet = tbSheetMapper.selectByPrimaryKey(sheetId);
        Integer id = tbSheet.getId();
        //查找指定歌单音乐
        TbMusicExample.Criteria tbMusicExample = new TbMusicExample.Criteria().andSheetIdEqualTo(id);
        TbMusicExample tbMusicExample1 = (TbMusicExample) tbMusicExample;
        List<TbMusic> tbMusics = tbMusicMapper.selectByExample(tbMusicExample);
        return tbMusics;
    }*/

    @Override
    public Integer addSheet(String sheetName) {
        int insert=0;
        TbSheet tbSheet = new TbSheet();
        tbSheet.setSheetName(sheetName);
        if (sheetName!=null&sheetName!=""&!(sheetName.equals("undefined"))){
            insert = tbSheetMapper.insertSelective(tbSheet);
        }
        return insert;
    }

}
