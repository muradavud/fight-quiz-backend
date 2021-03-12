package com.muradavud.ufcquiz.ufcquiz.model;


import lombok.Data;

@Data
public class Fight {

    private String r_fighter;
    private String b_fighter;
    private String date;
    private String location;
    private String winner;

    public Fight(String r_fighter, String b_fighter, String date, String location, String winner) {
        this.r_fighter = r_fighter;
        this.b_fighter = b_fighter;
        this.date = date;
        this.location = location;
        this.winner = winner;
    }

}
