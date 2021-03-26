package com.muradavud.ufcquiz.ufcquiz.model;


import lombok.Data;

@Data
public class Fight {

    private String r_fighter;
    private String b_fighter;
    private String date;
    private String location;
    private String winner;

    private String r_age;
    private String b_age;
    private String r_height;
    private String b_height;
    private String r_reach;
    private String b_reach;
    private String r_weight;
    private String b_weight;
    private String weight_class;


    public Fight(String r_fighter, String b_fighter, String date, String location, String winner, String r_age, String b_age, String r_height, String b_height, String r_reach, String b_reach, String r_weight, String b_weight, String weight_class) {
        this.r_fighter = r_fighter;
        this.b_fighter = b_fighter;
        this.date = date;
        this.location = location;
        this.winner = winner;
        this.r_age = r_age;
        this.b_age = b_age;
        this.r_height = r_height;
        this.b_height = b_height;
        this.r_reach = r_reach;
        this.b_reach = b_reach;
        this.r_weight = r_weight;
        this.b_weight = b_weight;
        this.weight_class = weight_class;
    }
}
