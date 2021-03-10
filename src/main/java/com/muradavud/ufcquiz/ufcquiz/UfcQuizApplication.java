package com.muradavud.ufcquiz.ufcquiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UfcQuizApplication implements CommandLineRunner
{

	@Autowired
	private FighterImageService fighterImageScrapeService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(UfcQuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("HERE -> {}", fighterImageScrapeService.scrapeImageUrl("Ovince Saint Preux"));
	}
}
