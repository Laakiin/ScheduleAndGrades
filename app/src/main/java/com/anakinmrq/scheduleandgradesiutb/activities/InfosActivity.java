package com.anakinmrq.scheduleandgradesiutb.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.anakinmrq.scheduleandgradesiutb.R;

public class InfosActivity extends AppCompatActivity {

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
                InfosActivity.this.startActivity(scheduleIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, GradesActivity.class);
                InfosActivity.this.startActivity(gradesIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                InfosActivity.this.startActivity(settingsIntent);
                finishAndRemoveTask();
                return true;
            case R.id.menu_infos:
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
        setContentView(R.layout.infos_activity);

    }

}
