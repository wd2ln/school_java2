package com.pzz.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface JdbcTemplateDao {
    void selectAll();
    void setTemplate(JdbcTemplate template);
}
