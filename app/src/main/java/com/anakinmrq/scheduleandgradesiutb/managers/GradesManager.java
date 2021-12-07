package com.anakinmrq.scheduleandgradesiutb.managers;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GradesManager {

    private static final String url = "https://www.iutbeziers.fr/scodoc/index.php";

    public static String connect(String numetu){
        try{
            Connection.Response loginForm = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .execute();
            Document document = Jsoup.connect(url)
                    .data("nip", numetu)
                    .data("submit", "OK")
                    .cookies(loginForm.cookies())
                    .post();
            return document.html();
        }catch(Exception ex){
            ex.printStackTrace();
            return ex.getMessage();
        }

    }

}
