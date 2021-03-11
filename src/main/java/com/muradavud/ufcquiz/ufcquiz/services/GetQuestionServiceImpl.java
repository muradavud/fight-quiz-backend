package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.Question;
import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.entity.Fight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetQuestionServiceImpl implements GetQuestionService {

    @Autowired
    private FightDao dao;

    @Override
    public Question getRandomQuestion() {

        Fight fight = dao.retrieveRandomFight();
        String text =
                "In " + fight.getDate()
                + ", who won the fight between "
                + fight.getR_Fighter() + " and "
                + fight.getB_Fighter() + "?";

        return new Question(text, fight.getWinner());
    }
}
