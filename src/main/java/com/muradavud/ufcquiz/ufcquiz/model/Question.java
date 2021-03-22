package com.muradavud.ufcquiz.ufcquiz.model;

import lombok.Data;

import java.util.List;


@Data
public class Question {
    private String question;
    private String answer;
    private List<String> options;

    public Question(String question, String answer, List<String> options) {
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
}
