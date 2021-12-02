package com.anakinmrq.scheduleandgradesiutb;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class Settings extends AppCompatActivity {


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
                CloseApp();
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, Grades.class);
                Settings.this.startActivity(gradesIntent);
                CloseApp();
                return true;
            case R.id.menu_settings:
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, Infos.class);
                Settings.this.startActivity(infosIntent);
                CloseApp();
                return true;
            case R.id.menu_home:
                CloseApp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void exitIntent(View v){finishAndRemoveTask();}

    public String fName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        activity=this;
    }
    static public Activity activity;

    public static void CloseApp(){
        activity.finish();
    }

    public void saveInfo(View v){
        EditText etNumEtu=(EditText) findViewById(R.id.NumEtu);
        EditText etURL=(EditText) findViewById(R.id.URL);
        String NumEtu=etNumEtu.getText().toString();
        String URL=etURL.getText().toString();
        createUrlFile(URL);
        createNumEtuFile(NumEtu);
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

        public void createNumEtuFile(String NumEtu) {
            try {
                fName = getFilesDir().getAbsolutePath() + "/numetu.txt";
                PrintStream ps = new PrintStream(fName);
                ps.println(NumEtu);
                ps.close();
                Log.d("mrq-file", "NumEtu File " + fName + " created.");
            } catch (Exception e) {
                Log.e("mrq-file", e.toString());
            }
        }
}