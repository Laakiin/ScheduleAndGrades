package com.anakinmrq.scheduleandgradesiutb.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anakinmrq.scheduleandgradesiutb.R;

import java.io.BufferedReader;
import java.io.FileReader;

public class Schedule extends AppCompatActivity {
    static Activity activity;
    public void CloseApp(){
        activity=this;
        activity.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_schedule:
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, Grades.class);
                startActivity(gradesIntent);
                CloseApp();
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, Settings.class);
                startActivity(settingsIntent);
                CloseApp();
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, Infos.class);
                startActivity(infosIntent);
                CloseApp();
                return true;
            case R.id.menu_home:
                CloseApp();
                return true;
            case R.id.selectprofile:
                Intent profileIT = new Intent(this, SelectProfileActivity.class);
                startActivity(profileIT);
                CloseApp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setJavaScriptEnabled(true);
        String URL =  readLine(0,"url.txt");
        if(URL.isEmpty()){
            Context context=getApplicationContext();
            int duration= Toast.LENGTH_SHORT;
            Toast t= Toast.makeText(context,R.string.incURL,duration);
            t.show();
            CloseApp();
        }
        else{
            myWebView.loadUrl(URL);
        }


        activity=this;
    }
}
