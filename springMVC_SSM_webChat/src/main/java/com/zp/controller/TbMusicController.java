package com.zp.controller;

import com.zp.entity.TbMusic;
import com.zp.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("music")
public class TbMusicController {
    private final TbMusicService tbMusicService;

    public TbMusicController(TbMusicService tbMusicService) {
        this.tbMusicService = tbMusicService;
    }

    @RequestMapping("findAll")
    public List<TbMusic> findAll(){
        return tbMusicService.findAll();
    }

    @RequestMapping("findById")
    public TbMusic findAll(Integer musicId){
        return tbMusicService.findById(musicId);
    }


    @RequestMapping("prevSong")
    public TbMusic preSong(Integer musicId){
        return tbMusicService.preSong(musicId);
    }
    @RequestMapping("nextSong")
    public TbMusic nextSong(Integer musicId){
        return tbMusicService.nextSong(musicId);
    }

    @RequestMapping("search")
    public List<TbMusic> searchSongList(String keyword){
        return tbMusicService.searchSongs(keyword);
    }


}
