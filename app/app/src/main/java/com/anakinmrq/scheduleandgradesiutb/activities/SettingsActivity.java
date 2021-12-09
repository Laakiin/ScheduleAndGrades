package com.anakinmrq.scheduleandgradesiutb.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anakinmrq.scheduleandgradesiutb.R;
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.objects.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;


public class SettingsActivity extends AppCompatActivity {

    private static SettingsActivity instance;
    public static SettingsActivity getInstance() {return instance;}

    public String fName;

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
                SettingsActivity.this.startActivity(scheduleIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, GradesActivity.class);
                SettingsActivity.this.startActivity(gradesIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_settings:
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, InfosActivity.class);
                SettingsActivity.this.startActivity(infosIntent);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
        setContentView(R.layout.settings_activity);

    }

    public void displayURL(View v){
        Settings settings = FilesManager.getSettings();
        String URL = (settings.getEDT_URL() == null ? getResources().getString(R.string.urlnoregistered) : settings.getEDT_URL());
        Toast.makeText(getApplicationContext(), URL, Toast.LENGTH_SHORT).show();
    }

    public void newProfile(View v){
        Intent it = new Intent(this, NewProfileActivity.class);
        startActivity(it);
        finish();
    }

    public void saveInfo(View v){
        EditText etURL=(EditText) findViewById(R.id.URL);
        String URL=etURL.getText().toString();
        Settings settings = FilesManager.getSettings();
        settings.setEDT_URL(URL);
        FilesManager.setSettings(settings);
        FilesManager.saveSettings();

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.settingssave), Toast.LENGTH_SHORT).show();
    }

}