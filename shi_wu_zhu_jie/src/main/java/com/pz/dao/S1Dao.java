package com.pz.dao;

import java.math.BigDecimal;

public interface S1Dao {
    // 加钱
    void increaseMoney(Integer id, BigDecimal money);

    // 减钱
    void decreaseMoney(Integer id, BigDecimal money);
}
