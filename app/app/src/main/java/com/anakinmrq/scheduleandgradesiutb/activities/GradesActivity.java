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

public class GradesActivity extends AppCompatActivity {

    private static GradesActivity instance;
    public static GradesActivity getInstance(){return instance;}

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
                Intent scheduleIntent = new Intent(this, ScheduleActivity.class);
                GradesActivity.this.startActivity(scheduleIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_grades:
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                GradesActivity.this.startActivity(settingsIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, InfosActivity.class);
                GradesActivity.this.startActivity(infosIntent);
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
        instance = this;
        setContentView(R.layout.grades_activity);

        String numetu = ProfilesManager.getCurrentProfile().getNumetu();
        if (numetu == null) {
            Toast.makeText(getApplicationContext(), R.string.noprofile, Toast.LENGTH_SHORT).show();
            finishAndRemoveTask();
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
                GradesActivity.getInstance().runOnUiThread(new Runnable() {
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
