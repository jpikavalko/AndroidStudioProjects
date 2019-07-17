package com.jukkaikavalko.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{

    private TextView showMessage;
    private Button backButt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get extras from First Activity
        Bundle extras = getIntent().getExtras();

        // Objects
        showMessage = findViewById(R.id.tvMessage);
        backButt = findViewById(R.id.backButton);

        if (extras != null){
            int number = extras.getInt("MagicNumber");
            String message = extras.getString("Message");
            showMessage.setText(String.valueOf(number));
        }

        backButt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("ReturnData", "From Second Activity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
