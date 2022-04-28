package com.zp.dao.impl;

import com.zp.dao.NoteTypeDao;
import com.zp.entity.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteTypeDaoImpl implements NoteTypeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<NoteType> findAll() {
        return jdbcTemplate.query("select * from tb_note_type",new BeanPropertyRowMapper<>(NoteType.class));
    }

    @Override
    public Integer insert(NoteType noteType) {
        return jdbcTemplate.update("insert into tb_note_type(type_name,user_id) values(?, ?)",noteType.getTypeName(),noteType.getUserId());
    }

    @Override
    public Integer del(Integer id) {
        return jdbcTemplate.update("delete from tb_note_type where id=?",id);
    }
}
