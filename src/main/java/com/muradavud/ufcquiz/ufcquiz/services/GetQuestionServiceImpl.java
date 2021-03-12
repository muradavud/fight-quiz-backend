package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.model.Fight;
import com.muradavud.ufcquiz.ufcquiz.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetQuestionServiceImpl implements GetQuestionService {

    private FightDao dao;

    public GetQuestionServiceImpl(FightDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getRandomQuestion() {
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
            return new Question(text, fight.getR_fighter(), options);
        }
        else if (fight.getWinner().equalsIgnoreCase("blue")) {
            return new Question(text, fight.getB_fighter(), options);
        }
        else
            return getRandomQuestion();
    }
}
