package com.zp.service;

import com.zp.entity.TbUser;
import org.springframework.web.servlet.ModelAndView;

public interface TbUserService {
    TbUser login(String username, String password, Integer remember);
}
