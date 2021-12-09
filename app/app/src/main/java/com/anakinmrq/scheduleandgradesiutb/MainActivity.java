package com.anakinmrq.scheduleandgradesiutb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.anakinmrq.scheduleandgradesiutb.activities.GradesActivity;
import com.anakinmrq.scheduleandgradesiutb.activities.InfosActivity;
import com.anakinmrq.scheduleandgradesiutb.activities.ScheduleActivity;
import com.anakinmrq.scheduleandgradesiutb.activities.SettingsActivity;
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.managers.ProfilesManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FilesManager.setupFiles(new File(getFilesDir().getAbsolutePath()));
        getSupportActionBar().hide();
    }

    public void schedule(View v){
        Intent scheduleIntent = new Intent(this, ScheduleActivity.class);
        this.startActivity(scheduleIntent);
    }
    public void settings(View v){
        Intent scheduleIntent = new Intent(this, SettingsActivity.class);
        this.startActivity(scheduleIntent);
    }
    public void infos(View v){
        Intent scheduleIntent = new Intent(this, InfosActivity.class);
        this.startActivity(scheduleIntent);
    }
    public void grades(View v){
        if(ProfilesManager.getCurrentProfile() == null){
            Toast.makeText(getApplicationContext(), "Aucun profil sélectionné", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent scheduleIntent = new Intent(this, GradesActivity.class);
        this.startActivity(scheduleIntent);
    }

}