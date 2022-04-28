package com.zp.service;

import com.zp.entity.TbMusic;
import com.zp.entity.TbSheet;

import java.util.List;

public interface TbSheetService {
    //获取歌单列表
    public List<TbSheet> findAll();
    //获取指定歌单下歌曲
  //  public List<TbMusic> findBySheet(Integer sheetId);
    //增加歌单
    public Integer addSheet(String sheetName);

}
