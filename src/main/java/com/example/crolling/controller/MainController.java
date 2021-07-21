package com.example.crolling.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/")
    public String index(String text, Model model) throws IOException {
        String url = "https://www.google.com/search?q="+text+" %EC%9C%A0%ED%8A%9C%EB%B8%8C&sxsrf=ALeKk00uH92k3B2MeaXJpkEIFweUmFnc8A:1626870262925&source=lnms&sa=X&ved=2ahUKEwjLw_eAlPTxAhVDCd4KHRk6AIwQ_AUoAHoECAEQAg&biw=736&bih=788&dpr=1";
        Document doc = Jsoup.connect(url).get();
        Element el = doc.select("a.rGhul").first();
        String link = el.absUrl("href"); //유튜브 링크
        System.out.println(link);

        Document doc2 = Jsoup.connect(link).get();
        String thumbnailUrl = doc2.select("link[itemprop=thumbnailUrl]")
                .first()
                .absUrl("href"); //유튜브 썸네일
        System.out.println(thumbnailUrl);

        model.addAttribute("link",link);
        model.addAttribute("img",thumbnailUrl);

        return "index";
    }
}