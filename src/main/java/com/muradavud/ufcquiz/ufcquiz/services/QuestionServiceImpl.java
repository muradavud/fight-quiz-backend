package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import com.muradavud.ufcquiz.ufcquiz.model.FightQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private FightDao dao;

    public QuestionServiceImpl(FightDao dao) {
        this.dao = dao;
    }

    @Override
    public FightQuestion makeRandomFightQuestion() {
        Fight fight = dao.retrieveRandomFight();

        String text =
                "In " + fight.getDate()
                + ", who won the fight between "
                + fight.getR_fighter() + " and "
                + fight.getB_fighter() + "?";

        List<String> options = new ArrayList<>();
        options.add(fight.getR_fighter());
        options.add(fight.getB_fighter());

        if (fight.getWinner().equalsIgnoreCase("red")) {
            return new FightQuestion(text, fight.getR_fighter(), options, fight);
        }
        else if (fight.getWinner().equalsIgnoreCase("blue")) {
            return new FightQuestion(text, fight.getB_fighter(), options, fight);
        }
        else
            return makeRandomFightQuestion();
    }
}
