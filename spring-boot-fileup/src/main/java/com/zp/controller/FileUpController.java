package com.zp.controller;

import com.zp.util.FileUpUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileUpController {
    @PostMapping("up")
    public String formUpload(@RequestPart("header") MultipartFile header,
                             @RequestPart("photos") MultipartFile[] photos) {

        if (!header.isEmpty()) {
            FileUpUtil.fileup(header);
        }

        if (photos != null && photos.length > 0) {
            for (MultipartFile photo : photos) {
                FileUpUtil.fileup(photo);
            }
        }

        return "redirect:/success.html";
    }
}
