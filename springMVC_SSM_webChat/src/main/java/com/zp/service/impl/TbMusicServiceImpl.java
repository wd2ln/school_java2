package com.zp.service.impl;

import com.zp.dao.TbMusicMapper;
import com.zp.entity.TbMusic;
import com.zp.entity.TbMusicExample;
import com.zp.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;
    @Override
    public List<TbMusic> findAll() {
        //无条件查全部
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic preSong(Integer musicId) {
        if (musicId<=1){
            musicId=tbMusicMapper.findMaxId();
        }else {
            musicId--;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId=tbMusicMapper.findMaxId();
        if (musicId>=maxId){
            musicId=1;
        }else {
            musicId++;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> searchSongs(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();
        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();
        criteria.andMusicNameLike("%"+keyword+"%");
        return tbMusicMapper.selectByExample(tbMusicExample);
    }

    @Override
    public List<TbMusic> searchSongsGrop(String sheetName) {
        return tbMusicMapper.selectByFind(sheetName);
    }
}
