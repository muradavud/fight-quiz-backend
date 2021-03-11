package com.muradavud.ufcquiz.ufcquiz.services;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FighterImageServiceImpl implements FighterImageService {

    @Override
    public String scrapeImageUrl(String name) throws IOException {

        String scrapeUrl = "https://www.ufc.com/athlete/";
        name = name.replaceAll("\\s","-");

        scrapeUrl = scrapeUrl + name;

        Connection.Response resp = Jsoup.connect(scrapeUrl) //
                .timeout(5000) //
                .method(Connection.Method.GET) //
                .execute();

        Document doc = resp.parse();;
        Element element = doc.select("div.c-bio__image *").first();
        String imgUrl = element.attr("src");

        return imgUrl;
    }
}
