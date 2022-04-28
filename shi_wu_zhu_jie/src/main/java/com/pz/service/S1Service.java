package com.pz.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface S1Service {
    /**
     * 转账
     *
     * @param from 从哪里转
     * @param to 转到哪里去
     * @param money 转账金额
     */
    void transfer(Integer from, Integer to, BigDecimal money);
}
