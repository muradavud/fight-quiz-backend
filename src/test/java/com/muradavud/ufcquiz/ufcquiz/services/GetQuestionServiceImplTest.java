package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import com.muradavud.ufcquiz.ufcquiz.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GetQuestionServiceImplTest {

    @InjectMocks
    GetQuestionServiceImpl getQuestionService;

    @Mock
    FightDao dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getRandomQuestions_StringIntegrity() {
        when(dao.retrieveRandomFight()).thenReturn(new Fight(
                "fighterR",
                "fighterB",
                "01/01/2000",
                "London",
                "red")
        );
        Question question = getQuestionService.getRandomQuestion();

        assertFalse(question.getQuestion().isEmpty());
        assertFalse(question.getOptions().isEmpty());
        assertFalse(question.getAnswer().isEmpty());
        assertEquals(question.getOptions().size(), 2);
    }

    @Test
    void getRandomQuestion_BadWinner_NewCall() {
        when(dao.retrieveRandomFight()).thenReturn(new Fight(
                "fighterR",
                "fighterB",
                "01/01/2000",
                "London",
                " "
        )).thenReturn(new Fight(
                "fighterR",
                "fighterB",
                "01/01/2000",
                "London",
                "Red")
        );
        Question question = getQuestionService.getRandomQuestion();
        assertEquals(question.getAnswer(), "fighterR");
    }
}