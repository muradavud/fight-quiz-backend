package com.muradavud.ufcquiz.ufcquiz;

import com.muradavud.ufcquiz.ufcquiz.services.GetQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Quiz {

    @Autowired
    GetQuestionService getQuestionService;

    private int numberOfQuestions;
    private int currentQuestion;
    private List<Question> questions = new ArrayList<>();



    public void initQuiz(int numberOfQuestions) {
        //this.numberOfQuestions = numberOfQuestions;
        for (int i = 0; i < numberOfQuestions; i = i + 1) {
            questions.add(getQuestionService.getRandomQuestion());
        }
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "getQuestionService=" + getQuestionService +
                ", numberOfQuestions=" + numberOfQuestions +
                ", currentQuestion=" + currentQuestion +
                ", questions=" + questions +
                '}';
    }
}
