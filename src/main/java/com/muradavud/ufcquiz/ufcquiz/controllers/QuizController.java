package com.muradavud.ufcquiz.ufcquiz.controllers;

import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class QuizController {

    QuizService quizService;
    FighterImageService fighterImageService;

    public QuizController(QuizService quizService, FighterImageService fighterImageService) {
        this.quizService = quizService;
        this.fighterImageService = fighterImageService;
    }


    @GetMapping(value = "/quiz/start")
    public String startQuiz(
            @RequestParam(value = "number_of_questions") String numberOfQuestions) throws RuntimeException {

        if(Integer.parseInt(numberOfQuestions) < 1 || Integer.parseInt(numberOfQuestions) > 50) {
            throw new RuntimeException("Invalid number of questions");
        }
        else {
            log.info("Initializing Quiz. Number of question -> {}", numberOfQuestions);
            return quizService.initQuiz(Integer.parseInt(numberOfQuestions));
        }
    }



//    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
//    public Object handleAnswer(
//            @RequestParam(value = "btn", required = false, defaultValue = "") String userAnswer,
//            Model model) throws IOException {
//
//        if(quizService.isClosed()){
//            return "index";
//        }
//        if(!userAnswer.isEmpty()) {
//            quizService.postAnswer(userAnswer);
//            log.info("User answer -> {}", userAnswer);
//            if (!quizService.iterateToNextQuestion()) {
//                quizService.finish();
//                model.addAttribute("result", quizService.getResult());
//                log.info("Closing Quiz. Number of correct answers -> {}", quizService.getResult());
//                return "index";
//            }
//        }
//        Question question = quizService.getCurrentQuestion();
//        model.addAttribute("question", question.getQuestion());
//        model.addAttribute("red_fighter", question.getOptions().get(0));
//        model.addAttribute("blue_fighter", question.getOptions().get(1));
//        model.addAttribute("r_img", fighterImageService.scrapeImageUrl(question.getOptions().get(0)));
//        model.addAttribute("b_img", fighterImageService.scrapeImageUrl(question.getOptions().get(1)));
//        log.info("Question {} -> {}", quizService.getCurrentQuestionIndex(), question.getQuestion());
//
//        return "lol";
//    }

}
