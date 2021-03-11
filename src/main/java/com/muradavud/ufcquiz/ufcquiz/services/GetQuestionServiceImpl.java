package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        List<String> options = new ArrayList<>();
        options.add(fight.getR_Fighter());
        options.add(fight.getB_Fighter());

        if (fight.getWinner().equalsIgnoreCase("red")) {
            return new Question(text, fight.getR_Fighter(), options);
        }
        else
            return new Question(text, fight.getB_Fighter(), options);
    }
}
