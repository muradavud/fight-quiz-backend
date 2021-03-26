package com.muradavud.ufcquiz.ufcquiz.dao;

import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FightRowMapper implements RowMapper<Fight> {
    @Override
    public Fight mapRow(ResultSet resultSet, int i) throws SQLException {
        Fight fight = new Fight(
                resultSet.getString("R_FIGHTER"),
                resultSet.getString("B_FIGHTER"),
                resultSet.getString("DATE"),
                resultSet.getString("LOCATION"),
                resultSet.getString("WINNER"),
                resultSet.getString("R_AGE"),
                resultSet.getString("B_AGE"),
                resultSet.getString("R_HEIGHT_CMS"),
                resultSet.getString("B_HEIGHT_CMS"),
                resultSet.getString("R_REACH_CMS"),
                resultSet.getString("B_REACH_CMS"),
                resultSet.getString("R_WEIGHT_LBS"),
                resultSet.getString("B_WEIGHT_LBS"),
                resultSet.getString("WEIGHT_CLASS"));
        return fight;
    }
}
