package com.anakinmrq.scheduleandgradesiutb.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.anakinmrq.scheduleandgradesiutb.R;

public class Infos extends AppCompatActivity {
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
                Intent scheduleIntent = new Intent(this, Schedule.class);
                Infos.this.startActivity(scheduleIntent);
                CloseApp();
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, Grades.class);
                Infos.this.startActivity(gradesIntent);
                CloseApp();
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, Settings.class);
                Infos.this.startActivity(settingsIntent);
                CloseApp();
                return true;
            case R.id.menu_infos:
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infos);
        activity=this;
    }

}
