package com.anakinmrq.scheduleandgradesiutb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
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
                MainActivity.this.startActivity(scheduleIntent);
                return true;
            case R.id.menu_grades:
                Intent gradesIntent = new Intent(this, Grades.class);
                MainActivity.this.startActivity(gradesIntent);
                return true;
            case R.id.menu_settings:
                Intent settingsIntent = new Intent(this, Settings.class);
                MainActivity.this.startActivity(settingsIntent);
                return true;
            case R.id.menu_infos:
                Intent infosIntent = new Intent(this, Infos.class);
                MainActivity.this.startActivity(infosIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}