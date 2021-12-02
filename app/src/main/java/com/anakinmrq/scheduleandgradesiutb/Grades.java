package com.anakinmrq.scheduleandgradesiutb;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Grades extends AppCompatActivity {
    public String numEtu;
    public boolean b;

    public String readLine(int line, String fName) {
        FileReader tempFileReader = null;
        BufferedReader tempBufferedReader = null;
        try {
            tempFileReader = new FileReader(getFilesDir().getAbsolutePath() + "/" + fName);
            tempBufferedReader = new BufferedReader(tempFileReader);
        } catch (Exception e) {
        }
        String returnStr = "ERROR";
        for (int i = 0; i < line - 1; i++) {
            try {
                tempBufferedReader.readLine();
            } catch (Exception e) {
            }
        }
        try {
            returnStr = tempBufferedReader.readLine();
        } catch (Exception e) {
        }

        return returnStr;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades);
        WebView myWebView = (WebView) findViewById(R.id.scodoc);

        numEtu = readLine(0, "numetu.txt");

        b = true;
        myWebView.loadUrl("https://www.iutbeziers.fr/scodoc/index.php");
        myWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {

                try {
                    int f = Integer.parseInt(numEtu);
                } catch (NumberFormatException e) {
                    b = false;
                }
                if (b == true) {
                    Log.d("mrq-webview","phptry");
                    myWebView.getSettings().setJavaScriptEnabled(true);
                    myWebView.loadUrl("javascript:document.getElementsByTagName('input')[0].value = " + numEtu);
                    myWebView.loadUrl("javascript:document.getElementsByTagName('input')[1].click()");
                }

            }
        });


    }
}
