package com.zp.controller;


import com.zp.entity.TbMusic;
import com.zp.entity.TbSheet;
import com.zp.service.TbMusicService;
import com.zp.service.TbSheetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    private final TbSheetService tbSheetService;
    private final TbMusicService tbMusicService;
    public TbSheetController(TbSheetService tbSheetService, TbMusicService tbMusicService) {
        this.tbSheetService = tbSheetService;
        this.tbMusicService = tbMusicService;
    }

    @RequestMapping("findAll")
    public List<TbSheet> findAll(){
        return tbSheetService.findAll();
    }

    @RequestMapping("insertSheet")
    public Integer insertSheet(String sheetName){
        System.out.println(sheetName);
        return tbSheetService.addSheet(sheetName);
    }

    @RequestMapping("findSongsBySheet")
    public List<TbMusic> searchSongList1(String sheetName){
        //System.out.println(sheetName);
        return tbMusicService.searchSongsGrop(sheetName);
    }
}
