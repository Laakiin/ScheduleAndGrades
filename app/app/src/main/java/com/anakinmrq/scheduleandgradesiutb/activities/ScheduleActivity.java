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
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.objects.Settings;

import java.io.BufferedReader;
import java.io.FileReader;

public class ScheduleActivity extends AppCompatActivity {

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
                Intent gradesIntent = new Intent(this, GradesActivity.class);
                startActivity(gradesIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, InfosActivity.class);
                startActivity(infosIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_home:
                finishAndRemoveTask();
                return true;
            case R.id.selectprofile:
                Intent profileIT = new Intent(this, SelectProfileActivity.class);
                startActivity(profileIT);
                finishAndRemoveTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setDisplayZoomControls(false);
        myWebView.getSettings().setJavaScriptEnabled(true);

        Settings settings = FilesManager.getSettings();
        String URL = settings.getEDT_URL();
        if(URL == null || URL.isEmpty()){
            Toast.makeText(getApplicationContext(),R.string.incURL,Toast.LENGTH_SHORT).show();
            finishAndRemoveTask();
            return;
        }

        myWebView.loadUrl(URL);

    }
}
