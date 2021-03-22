package com.muradavud.ufcquiz.ufcquiz.controllers;

import com.muradavud.ufcquiz.ufcquiz.model.Question;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class QuizController {


    FighterImageService fighterImageService;
    QuestionService questionService;

    public QuizController(FighterImageService fighterImageService, QuestionService questionService) {
        this.fighterImageService = fighterImageService;
        this.questionService = questionService;
    }

    @CrossOrigin(origins = "http://192.168.0.143:4200")
    @GetMapping(value = "/question/random")
    public Question getRandomQuestion() {
        return questionService.makeRandomQuestion();
    }

    @CrossOrigin(origins = "http://192.168.0.143:4200")
    @GetMapping(value = "/image")
    public String getFighterImage(@RequestParam String name) throws IOException {
        return fighterImageService.scrapeImageUrl(name);
    }

}
