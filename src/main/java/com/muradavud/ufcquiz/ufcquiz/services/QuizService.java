package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;

import java.util.concurrent.atomic.AtomicLong;

public interface QuizService {


    void setNumberOfQuestions(int numberOfQuestions);
    String initQuiz(int numberOfQuestions); //doesnt need id increment
    void finish();
    boolean isClosed();
    boolean iterateToNextQuestion();
    boolean postAnswer(String answer);
    Question getCurrentQuestion();
    int getCurrentQuestionIndex();
    String getResult();
}
