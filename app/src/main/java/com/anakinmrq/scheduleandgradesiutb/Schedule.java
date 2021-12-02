package com.anakinmrq.scheduleandgradesiutb;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Schedule extends AppCompatActivity {

    public String readLine(int line, String fName){
        FileReader tempFileReader = null;
        BufferedReader tempBufferedReader = null;
        try { tempFileReader = new FileReader(getFilesDir().getAbsolutePath() +"/"+fName);
            tempBufferedReader = new BufferedReader(tempFileReader);
        } catch (Exception e) { }
        String returnStr = "ERROR";
        for(int i = 0; i < line - 1; i++){
            try { tempBufferedReader.readLine(); } catch (Exception e) { }
        }
        try { returnStr = tempBufferedReader.readLine(); }  catch (Exception e) { }

        return returnStr;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        WebView myWebView = (WebView) findViewById(R.id.webview);



        myWebView.getSettings().setJavaScriptEnabled(true);
        String URL =  readLine(0,"url.txt");
        myWebView.loadUrl(URL);


    }
}
