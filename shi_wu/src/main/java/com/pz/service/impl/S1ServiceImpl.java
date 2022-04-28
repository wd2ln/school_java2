package com.pz.service.impl;

import com.pz.dao.S1Dao;
import com.pz.entity.S1;
import com.pz.service.S1Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

public class S1ServiceImpl implements S1Service {
    private S1Dao s1Dao;
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setS1Dao(S1Dao s1Dao) {
        this.s1Dao = s1Dao;
    }

    @Override
    public void transfer(Integer from, Integer to, BigDecimal money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //减钱
                s1Dao.decreaseMoney(from,money);

                //System.out.println("发生了异常");
                //int num = 1 / 0;
                //加钱
                s1Dao.increaseMoney(to,money);
            }
        });

    }
}
