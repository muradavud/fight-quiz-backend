package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuizServiceImpl implements QuizService {

    @Autowired
    GetQuestionService getQuestionService;

    private boolean isClosed;
    private int numberOfQuestions;
    private int currentQuestion;
    private List<Question> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();

    @Override
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public void initQuiz() {
        isClosed = false;
        currentQuestion = 0;
        for (int i = 0; i < numberOfQuestions; i = i + 1) {
            questions.add(getQuestionService.getRandomQuestion());
            answers.add("");
        }
    }

    @Override
    public boolean iterateToNextQuestion() {
        if(currentQuestion + 1 == numberOfQuestions) {
            return false;
        }
        currentQuestion = currentQuestion + 1;
        return true;
    }

    @Override
    public void close() {
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public void postAnswer(String answer) {
        answers.add(currentQuestion, answer);
        System.out.println(currentQuestion);
    }

    @Override
    public Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }
}
