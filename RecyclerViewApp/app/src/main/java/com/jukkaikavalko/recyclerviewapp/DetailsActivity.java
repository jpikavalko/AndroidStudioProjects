package com.jukkaikavalko.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity
{
    private TextView name;
    private TextView description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = findViewById(R.id.dNameID);
        description = findViewById(R.id.dDescriptionID);

        extras = getIntent().getExtras();

        if (extras != null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}
