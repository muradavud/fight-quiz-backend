package com.muradavud.ufcquiz.ufcquiz.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FightRowMapper implements RowMapper<Fight> {
    @Override
    public Fight mapRow(ResultSet resultSet, int i) throws SQLException {
        Fight fight = new Fight();
        fight.setR_Fighter(resultSet.getString("R_FIGHTER"));
        fight.setB_Fighter(resultSet.getString("B_FIGHTER"));
        fight.setDate(resultSet.getString("DATE"));
        fight.setLocation(resultSet.getString("LOCATION"));
        fight.setWinner(resultSet.getString("WINNER"));

        return fight;
    }
}
