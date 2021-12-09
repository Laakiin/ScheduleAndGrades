package com.anakinmrq.scheduleandgradesiutb.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.anakinmrq.scheduleandgradesiutb.R;
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.managers.ProfilesManager;
import com.anakinmrq.scheduleandgradesiutb.objects.Profile;

import java.util.ArrayList;

public class SelectProfileActivity extends AppCompatActivity {

    private static ListView lv;
    private static Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);

        lv=(ListView)findViewById(R.id.LVProfiles);
        ArrayList<String> prlist =new ArrayList<String>();

        for(Profile pr : FilesManager.getProfiles()){
            String str = pr.getNom()+" "+pr.getPrenom()+"       [ "+pr.getNumetu()+" ]";
            prlist.add(str);
        }

        ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.lineprofile, prlist);
        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String)lv.getItemAtPosition(position);

                Profile profile = FilesManager.getProfiles().get(position);
                ProfilesManager.setCurrentProfile(profile);

                if(currentToast != null) currentToast.cancel();
                currentToast = Toast.makeText(getApplicationContext(), "Profile: "+profile.getNom()+" "+profile.getPrenom()+" selected !", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Profile profile = FilesManager.getProfiles().get(position);
                FilesManager.removeProfile(profile);
                FilesManager.saveProfiles();

                lv.notify();

                return false;
            }
        });
    }


}