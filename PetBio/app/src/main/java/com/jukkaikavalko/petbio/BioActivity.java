package com.jukkaikavalko.petbio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity
{
    private ImageView petImage;
    private TextView petName;
    private TextView petBio;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        petImage = findViewById(R.id.PetImageViewID);
        petName = findViewById((R.id.PetNameTextViewID));
        petBio = findViewById((R.id.PetBioTextViewID));

        extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("name");
            String bio = extras.getString("bio");

            SetUp(name, bio);
        }
    }

    public void SetUp(String name, String bio)
    {
        if (name.equals("Murmeli")){
            petImage.setImageDrawable(getResources().getDrawable(R.drawable.moster_murmeli));
        }
        else if (name.equals("Roggo")){
            petImage.setImageDrawable(getResources().getDrawable(R.drawable.monster_kivi));

        }
        petName.setText(name);
        petBio.setText(bio);

    }
}
