package ru.syn.quotes.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BashParser {
    public Map<Integer,String> getIndex() throws IOException {
        Document doc = Jsoup.connect("http://www.ibash.org.ru/").get();
        Elements sourceQuotes = doc.select(".quote");
        Map<Integer,String> quotes = new HashMap<>();
        for (Element quoteElement : sourceQuotes) {
            int id = Integer.parseInt(quoteElement.select("b").first().text().substring(1));
            String text = quoteElement.select(".quotbody").first().text();
            quotes.put(id,text);
        }
        return quotes;
    }

    public Map<Integer, String> getPage(int page) {
        Map<Integer, String> quotes = new HashMap<>();
        try {
            Document doc = Jsoup.connect("http://www.ibash.org.ru/?page=" + page).get();
            Elements sourceQuotes = doc.select(".quote");
            for (Element quoteElement : sourceQuotes) {
                int id = Integer.parseInt(Objects.requireNonNull(quoteElement.select("b").first()).text().substring(1));
                String text = Objects.requireNonNull(quoteElement.select(".quotbody").first()).text();
                quotes.put(id, text);
            }
        } catch (IOException ignored) {
        }
        return quotes;
    }

    public Map.Entry<Integer, String> getRandom(){
        try {
            Document doc = Jsoup.connect("http://www.ibash.org.ru/random.php").get();
            Element quoteElement = doc.select(".quote").first();
            String realId = quoteElement.select("b").first().text();
            if (realId.equals("#???")) return  null;
            String text = quoteElement.select(".quotbody").first().text();
            return new AbstractMap.SimpleEntry<>(Integer.parseInt(realId.substring(1)),text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map.Entry<Integer, String> getById(int id){
        try {
            Document doc = Jsoup.connect("http://www.ibash.org.ru/quote.php?id=" + id).get();
            Element quoteElement = doc.select(".quote").first();
            String realId = quoteElement.select("b").first().text();
            if (realId.equals("#???")) return  null;
            String text = quoteElement.select(".quotbody").first().text();
            return new AbstractMap.SimpleEntry<>(id,text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}