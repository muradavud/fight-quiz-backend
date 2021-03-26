package com.muradavud.ufcquiz.ufcquiz.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping(value = "/question/random")
    public String getRandomQuestion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(questionService.makeRandomFightQuestion());

    }

    @GetMapping(value = "/image")
    public String getFighterImage(@RequestParam String name) throws IOException {
        return fighterImageService.scrapeImageUrl(name); // TODO return HashMap {name, url}
    }

}
