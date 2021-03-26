package com.muradavud.ufcquiz.ufcquiz.model;


import java.util.List;



public class FightQuestion extends Question {

    private Fight fight;

    public FightQuestion(String question, String answer, List<String> options, Fight fight) {
        super(question, answer, options);
        this.fight = fight;
    }

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }
}
