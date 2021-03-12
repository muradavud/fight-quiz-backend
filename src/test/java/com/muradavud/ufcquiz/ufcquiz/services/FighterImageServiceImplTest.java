package com.muradavud.ufcquiz.ufcquiz.services;

import com.muradavud.ufcquiz.ufcquiz.dao.FightDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FighterImageServiceImplTest {


    FighterImageServiceImpl fighterImageService;

    @BeforeEach
    void setUp() {
        fighterImageService = new FighterImageServiceImpl();
    }

    @Test
    void scrapeImageUrl_InvalidName_DefaultImage() throws IOException {
        assertEquals(fighterImageService.scrapeImageUrl("Murad Davidov"), "600px-no-image.png");
    }

    @Test
    void scrapeImageUrl_ValidName_NotDefaultImage() throws IOException {
        // Conor is a good bet
        assertNotEquals(fighterImageService.scrapeImageUrl("Conor McGregor"), "600px-no-image.png");
    }
}