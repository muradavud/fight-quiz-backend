package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;

public interface QuizService {

    void setNumberOfQuestions(int numberOfQuestions);
    void initQuiz();
    void close();
    boolean isClosed();
    boolean iterateToNextQuestion();
    void postAnswer(String answer);
    Question getCurrentQuestion();
}
