package com.muradavud.ufcquiz.ufcquiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuizController {

    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String startQuiz(Model model) {
        return "quiz";
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public String handleAnswer(@RequestParam String btn, Model model) {

        System.out.println(btn);
        return "quiz";
    }

}
