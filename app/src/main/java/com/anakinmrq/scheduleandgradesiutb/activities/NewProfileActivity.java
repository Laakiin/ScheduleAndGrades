package com.anakinmrq.scheduleandgradesiutb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.anakinmrq.scheduleandgradesiutb.R;
import com.anakinmrq.scheduleandgradesiutb.managers.FilesManager;
import com.anakinmrq.scheduleandgradesiutb.objects.Profile;
import com.anakinmrq.scheduleandgradesiutb.utils.VarUtils;

public class NewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
    }

    public void onValidate(View v){
        EditText tvnom = (EditText) findViewById(R.id.nomET);
        EditText tvprenom = (EditText) findViewById(R.id.prenomET);
        EditText tvnumetu = (EditText) findViewById(R.id.numetuET);

        String nom = tvnom.getText().toString().replaceAll(" ", "");
        String prenom = tvprenom.getText().toString().replaceAll(" ", "");
        String numetu = tvnumetu.getText().toString().replaceAll(" ", "");

        if(nom.isEmpty()){
            Toast.makeText(getApplicationContext(), "Last Name Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(prenom.isEmpty()){
            Toast.makeText(getApplicationContext(), "First Name Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(numetu.isEmpty() || !VarUtils.isEtuNumber(numetu)){
            Toast.makeText(getApplicationContext(), "Student Number Incorrect", Toast.LENGTH_SHORT).show();
            return;
        }

        Profile profile = new Profile(nom, prenom, numetu);
        FilesManager.addProfile(profile);
        FilesManager.saveProfiles();
        Toast.makeText(getApplicationContext(), "Profile Created !", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}