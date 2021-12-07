package com.anakinmrq.scheduleandgradesiutb.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anakinmrq.scheduleandgradesiutb.R;
import com.anakinmrq.scheduleandgradesiutb.managers.GradesManager;
import com.anakinmrq.scheduleandgradesiutb.managers.ProfilesManager;

import java.io.BufferedReader;
import java.io.FileReader;

public class Grades extends AppCompatActivity {

    private static Grades instance;
    public static Grades getInstance(){return instance;}

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
                Intent scheduleIntent = new Intent(this, Schedule.class);
                Grades.this.startActivity(scheduleIntent);
                this.finish();
                return true;
            case R.id.menu_grades:
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, Settings.class);
                Grades.this.startActivity(settingsIntent);
                this.finish();
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, Infos.class);
                Grades.this.startActivity(infosIntent);
                this.finish();
                return true;
            case R.id.menu_home:
                this.finish();
                return true;
            case R.id.selectprofile:
                Intent profileIT = new Intent(this, SelectProfileActivity.class);
                startActivity(profileIT);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.grades);

        String numetu = ProfilesManager.getCurrentProfile().getNumetu();
        if (numetu == null) {
            Toast.makeText(getApplicationContext(), R.string.noprofile, Toast.LENGTH_SHORT).show();
            this.finish();
            return;
        }

        WebView wbview = (WebView) findViewById(R.id.scodoc);
        wbview.getSettings().setDomStorageEnabled(true);
        wbview.getSettings().setBuiltInZoomControls(true);
        wbview.getSettings().setJavaScriptEnabled(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final String html = GradesManager.connect(numetu);
                Grades.getInstance().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        wbview.loadDataWithBaseURL("https://www.iutbeziers.fr/scodoc/", html, "text/html", "utf-8", null);
                    }
                });
            }
        }).start();
    }

    private static void showNotes(){

    }
}
