package com.zp.service;

import com.zp.entity.TbMusic;

import java.util.List;

public interface TbMusicService {
    List<TbMusic> findAll();

    TbMusic findById(Integer musicId);
    //上一首
    TbMusic preSong(Integer musicId);
    //下一首
    TbMusic nextSong(Integer musicId);
    //模糊查询
    List<TbMusic> searchSongs(String keyword);
    //分组查询
    List<TbMusic> searchSongsGrop(String sheetName);
}
