package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    GetQuestionService getQuestionService;

    private boolean isClosed;
    private int numberOfQuestions;
    private int numberOfCorrectAnswers;
    private int currentQuestionIndex;
    private List<Question> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();

    @Override
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    @Override
    public void initQuiz() {
        isClosed = false;
        currentQuestionIndex = 0;
        numberOfCorrectAnswers = 0;
        questions.clear();
        answers.clear();

        for (int i = 0; i < numberOfQuestions; i = i + 1) {
            questions.add(i, getQuestionService.getRandomQuestion());
            answers.add(i, "");
        }
    }

    @Override
    public boolean iterateToNextQuestion() {
        if(currentQuestionIndex + 1 == numberOfQuestions) {
            return false;
        }
        currentQuestionIndex = currentQuestionIndex + 1;
        return true;
    }

    @Override
    public void finish() {
        isClosed = true;
        for (int i = 0; i<numberOfQuestions; i++) {
            if (Objects.equals(answers.get(i), questions.get(i).getAnswer())) {
                numberOfCorrectAnswers = numberOfCorrectAnswers + 1;
            }
        }
    }

    @Override
    public String getResult() {
        return numberOfCorrectAnswers + " out of " + numberOfQuestions;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public boolean postAnswer(String answer) {
        if(answers.get(currentQuestionIndex).isEmpty()) {
            answers.add(currentQuestionIndex, answer);
            return true;
        }
        return false;
    }

    @Override
    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    @Override
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }
}
