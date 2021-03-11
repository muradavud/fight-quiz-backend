package com.muradavud.ufcquiz.ufcquiz;

import com.muradavud.ufcquiz.ufcquiz.services.FighterImageService;
import com.muradavud.ufcquiz.ufcquiz.services.FighterImageServiceImpl;
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

	public UfcQuizApplication(FighterImageServiceImpl fighterImageScrapeService, FightDao fightDao) {
		this.fighterImageService = fighterImageScrapeService;
		this.fightDao = fightDao;
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
	}
}
