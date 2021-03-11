package com.muradavud.ufcquiz.ufcquiz.model;

public class Fight {

    private String R_Fighter;
    private String B_Fighter;
    private String date;
    private String location;
    private String winner;

    public String getR_Fighter() {
        return R_Fighter;
    }

    public void setR_Fighter(String r_Fighter) {
        R_Fighter = r_Fighter;
    }

    public String getB_Fighter() {
        return B_Fighter;
    }

    public void setB_Fighter(String b_Fighter) {
        B_Fighter = b_Fighter;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "\nFight{" +
                "R_Fighter='" + R_Fighter + '\'' +
                ", B_Fighter='" + B_Fighter + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}
