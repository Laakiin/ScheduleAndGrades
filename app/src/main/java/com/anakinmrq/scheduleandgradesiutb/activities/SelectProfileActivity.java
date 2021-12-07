package com.anakinmrq.scheduleandgradesiutb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.anakinmrq.scheduleandgradesiutb.R;
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.objects.Profile;

import java.util.ArrayList;

public class SelectProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);

        ListView lv=(ListView)findViewById(R.id.LVProfiles);
        ArrayList<String> prlist =new ArrayList<String>();

        for(Profile pr : FilesManager.getProfiles()){
            String str = pr.getNom()+" "+pr.getPrenom()+"       [ "+pr.getNumetu()+" ]";
            prlist.add(str);
        }

        ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.lineprofile,
                prlist);
        lv.setAdapter(listAdapter);
    }
}