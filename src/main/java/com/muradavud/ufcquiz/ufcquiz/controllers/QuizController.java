package com.muradavud.ufcquiz.ufcquiz.controllers;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller
public class QuizController {

    QuizService quizService;
    FighterImageService fighterImageService;

    public QuizController(QuizService quizService, FighterImageService fighterImageService) {
        this.quizService = quizService;
        this.fighterImageService = fighterImageService;
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public String handleAnswer(
            @RequestParam(value = "number_of_questions", required = false, defaultValue = "") String number,
            @RequestParam(value = "btn", required = false, defaultValue = "") String userAnswer,
            Model model) throws IOException {

        if (!number.isEmpty()) {
            if(Integer.parseInt(number) < 1) { return "index"; }
            quizService.setNumberOfQuestions(Integer.parseInt(number));
            quizService.initQuiz();
            log.info("Initializing Quiz. Number of question -> {}", number);
        }
        if(quizService.isClosed()){
            return "index";
        }
        if(!userAnswer.isEmpty()) {
            quizService.postAnswer(userAnswer);
            log.info("User answer -> {}", userAnswer);
            if (!quizService.iterateToNextQuestion()) {
                quizService.finish();
                model.addAttribute("result", quizService.getResult());
                log.info("Closing Quiz. Number of correct answers -> {}", quizService.getResult());
                return "index";
            }
        }
        Question question = quizService.getCurrentQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("red_fighter", question.getOptions().get(0));
        model.addAttribute("blue_fighter", question.getOptions().get(1));
        model.addAttribute("r_img", fighterImageService.scrapeImageUrl(question.getOptions().get(0)));
        model.addAttribute("b_img", fighterImageService.scrapeImageUrl(question.getOptions().get(1)));
        log.info("Question {} -> {}", quizService.getCurrentQuestionIndex(), question.getQuestion());

        return "quiz";
    }

}
