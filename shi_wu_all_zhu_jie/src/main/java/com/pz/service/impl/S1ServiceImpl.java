package com.pz.service.impl;

import com.pz.dao.S1Dao;
import com.pz.service.S1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


// 使用注解声明该类中的所有方法都支持事务，此注解也可以配置在方法上
@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,readOnly = false)
public class S1ServiceImpl implements S1Service {
    @Autowired
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
