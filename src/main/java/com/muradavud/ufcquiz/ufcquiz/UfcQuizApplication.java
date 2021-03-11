package com.muradavud.ufcquiz.ufcquiz;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageServiceImpl;
import com.muradavud.ufcquiz.ufcquiz.services.GetQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UfcQuizApplication implements CommandLineRunner
{

	private FighterImageService fighterImageService;
	private FightDao fightDao;
	private Quiz quiz;
	private GetQuestionService getQuestionService;

	public UfcQuizApplication(FighterImageService fighterImageService, FightDao fightDao, Quiz quiz, GetQuestionService getQuestionService) {
		this.fighterImageService = fighterImageService;
		this.fightDao = fightDao;
		this.quiz = quiz;
		this.getQuestionService = getQuestionService;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(UfcQuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("IMAGE -> {}", fighterImageService.scrapeImageUrl("Ovince Saint Preux"));
		logger.info("ID {} -> {}", 3, fightDao.findById(3).getB_Fighter());
		logger.info("RANDOM -> {}", fightDao.retrieveRandomFight().toString());

//		int i = 0;
//		while (i < 5) {
//			logger.info("RANDOM -> {}", getQuestionService.getRandomQuestion().getQuestion());
//			i++;
//		}

//		quiz.initQuiz(5);
//		logger.info("QUIZ -> {}", quiz.getQuestions().get(4).getQuestion());
	}
}
