package com.anakinmrq.scheduleandgradesiutb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void schedule(View v){
        Intent scheduleIntent = new Intent(this, Schedule.class);
        this.startActivity(scheduleIntent);
    }
    public void settings(View v){
        Intent scheduleIntent = new Intent(this, Settings.class);
        this.startActivity(scheduleIntent);
    }
    public void infos(View v){
        Intent scheduleIntent = new Intent(this, Infos.class);
        this.startActivity(scheduleIntent);
    }
    public void grades(View v){
        Intent scheduleIntent = new Intent(this, Grades.class);
        this.startActivity(scheduleIntent);
    }
    public void siteIUTB(View v){
        Intent scheduleIntent = new Intent(this, iutbSite.class);
        this.startActivity(scheduleIntent);
    }

}