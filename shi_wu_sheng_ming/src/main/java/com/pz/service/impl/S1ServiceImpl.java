package com.pz.service.impl;

import com.pz.dao.S1Dao;
import com.pz.service.S1Service;


import java.math.BigDecimal;

public class S1ServiceImpl implements S1Service {
    private S1Dao s1Dao;

    public void setS1Dao(S1Dao s1Dao) {
        this.s1Dao = s1Dao;
    }

    @Override
    public void transfer(Integer from, Integer to, BigDecimal money) {
                //减钱
                s1Dao.decreaseMoney(from,money);

                //System.out.println("发生了异常");
                //int num = 1 / 0;
                //加钱
                s1Dao.increaseMoney(to,money);
            }


}
