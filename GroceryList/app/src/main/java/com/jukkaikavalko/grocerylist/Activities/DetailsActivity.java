package com.jukkaikavalko.grocerylist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jukkaikavalko.grocerylist.R;

public class DetailsActivity extends AppCompatActivity
{
    private TextView itemName;
    private TextView quantity;
    private TextView dateAdded;
    private int groceryId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        itemName = findViewById(R.id.itemNameDetails);
        quantity = findViewById(R.id.quantityDetails);
        dateAdded = findViewById(R.id.dateAddedDetails);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            itemName.setText(bundle.getString("name"));
            quantity.setText(bundle.getString("quantity"));
            dateAdded.setText(bundle.getString("date"));
            groceryId = bundle.getInt("id");
        }
    }
}
