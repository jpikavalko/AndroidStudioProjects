package com.jukkaikavalko.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ImageView rockView;
    private ImageView catView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockView = findViewById(R.id.rockID);
        catView = findViewById(R.id.catID);

        catView.setOnClickListener(this);
        rockView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.catID:
                // Go to second activity
                Intent catIntent = new Intent(MainActivity.this, BioActivity.class);
                catIntent.putExtra("name", "Murmeli");
                catIntent.putExtra("bio", "Murmeli loves everyone who gives him food");
                startActivity(catIntent);
                break;

            case R.id.rockID:
                // Go to second activity
                Intent rockIntent = new Intent(MainActivity.this, BioActivity.class);
                rockIntent.putExtra("name", "Roggo");
                rockIntent.putExtra("bio", "Roggo doesn't move much. She might be dead.");
                startActivity(rockIntent);
                break;
        }


    }
}
