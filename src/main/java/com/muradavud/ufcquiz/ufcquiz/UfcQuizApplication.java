package com.muradavud.ufcquiz.ufcquiz;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.GetQuestionService;
import com.muradavud.ufcquiz.ufcquiz.services.QuizServiceImpl;
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
	private QuizServiceImpl quiz;
	private GetQuestionService getQuestionService;

	public UfcQuizApplication(FighterImageService fighterImageService, FightDao fightDao, QuizServiceImpl quiz, GetQuestionService getQuestionService) {
		this.fighterImageService = fighterImageService;
		this.fightDao = fightDao;
		this.quiz = quiz;
		this.getQuestionService = getQuestionService;
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(UfcQuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
