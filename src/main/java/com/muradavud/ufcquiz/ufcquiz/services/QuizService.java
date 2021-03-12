package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;

public interface QuizService {

    void setNumberOfQuestions(int numberOfQuestions);
    void initQuiz();
    void finish();
    boolean isClosed();
    boolean iterateToNextQuestion();
    boolean postAnswer(String answer);
    Question getCurrentQuestion();
    int getCurrentQuestionIndex();
    String getResult();
}
