package com.muradavud.ufcquiz.ufcquiz.dao;

import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FightDao {

    private final String fightTable = "ufc_fight";
    private final JdbcTemplate jdbcTemplate;

    public FightDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Fight findById(int id) {
        return jdbcTemplate.queryForObject(
                String.format("SELECT * FROM %s WHERE id = ?", fightTable),
                new FightRowMapper(), 
                id);
    }

    public Fight retrieveRandomFight() {
        return jdbcTemplate.queryForObject(
                String.format("SELECT * FROM %s " +
                        "ORDER BY RAND() " +
                        "LIMIT 1", fightTable),
                new FightRowMapper());
    }

}
