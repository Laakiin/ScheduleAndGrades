package com.anakinmrq.scheduleandgradesiutb.activities;

import android.app.Activity;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;


public class Settings extends AppCompatActivity {

    private static Settings instance;
    public static Settings getInstance() {return instance;}

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
                Intent scheduleIntent = new Intent(this, Schedule.class);
                Settings.this.startActivity(scheduleIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, Grades.class);
                Settings.this.startActivity(gradesIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_settings:
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, Infos.class);
                Settings.this.startActivity(infosIntent);
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
        setContentView(R.layout.settings);

    }

    public void displayURL(View v){
        String URL = readLine(0,"url.txt");

        Context context=getApplicationContext();
        int duration=Toast.LENGTH_SHORT;
        Toast t= Toast.makeText(context,URL,duration);
        t.show();
    }

    public String readLine(int line, String fName) {
        FileReader tempFileReader = null;
        BufferedReader tempBufferedReader = null;
        try {
            tempFileReader = new FileReader(getFilesDir().getAbsolutePath() + "/" + fName);
            tempBufferedReader = new BufferedReader(tempFileReader);
        } catch (Exception e) {}
        String returnStr = "ERROR";
        for (int i = 0; i < line - 1; i++) {
            try {
                tempBufferedReader.readLine();
            } catch (Exception e) {}
        }
        try {
            returnStr = tempBufferedReader.readLine();
        } catch (Exception e) {}

        return returnStr;
    }


    public void newProfile(View v){
        Intent it = new Intent(this, NewProfileActivity.class);
        startActivity(it);
        finish();
    }


    public void createUrlFile(String URL) {
        try {
            fName = getFilesDir().getAbsolutePath() + "/url.txt";
            PrintStream ps = new PrintStream(fName);
            ps.println(URL);
            ps.close();
            Log.d("mrq-file", "URL File " + fName + " created.");
        } catch (Exception e) {
            Log.e("mrq-file", e.toString());
        }
    }

}