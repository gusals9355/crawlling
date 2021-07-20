package com.example.crolling.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
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
    public String index(String text) throws IOException {
        String url = "https://www.youtube.com/results?search_query="+text;
        Document doc = Jsoup.connect(url).get();
        Jsoup.parse(doc);

        return "index";
    }
}
