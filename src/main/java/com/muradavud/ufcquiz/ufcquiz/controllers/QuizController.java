package com.muradavud.ufcquiz.ufcquiz.controllers;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class QuizController {

    QuizService quizService;
    FighterImageService fighterImageService;

    public QuizController(QuizService quizService, FighterImageService fighterImageService) {
        this.quizService = quizService;
        this.fighterImageService = fighterImageService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String startQuiz(@RequestParam int number, Model model) throws IOException {

        quizService.setNumberOfQuestions(number);
        quizService.initQuiz();
        logger.info("Initializing Quiz. Number of question -> {}", number);

        Question question = quizService.getCurrentQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("red_fighter", question.getOptions().get(0));
        model.addAttribute("blue_fighter", question.getOptions().get(1));
        model.addAttribute("r_img", fighterImageService.scrapeImageUrl(question.getOptions().get(0)));
        model.addAttribute("b_img", fighterImageService.scrapeImageUrl(question.getOptions().get(1)));
        logger.info("Question -> {}", question.getQuestion());

        return "quiz";
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public String handleAnswer(@RequestParam String btn, Model model) throws IOException {

        if(quizService.isClosed()){
            return "index";
        }

        quizService.postAnswer(btn);
        logger.info("Answer -> {}", btn);
        if (!quizService.iterateToNextQuestion()){
            quizService.close();
            return "index";
        }

        Question question = quizService.getCurrentQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("red_fighter", question.getOptions().get(0));
        model.addAttribute("blue_fighter", question.getOptions().get(1));
        model.addAttribute("r_img", fighterImageService.scrapeImageUrl(question.getOptions().get(0)));
        model.addAttribute("b_img", fighterImageService.scrapeImageUrl(question.getOptions().get(1)));
        logger.info("Question number -> {}", question.getQuestion());

        return "quiz";
    }

}
