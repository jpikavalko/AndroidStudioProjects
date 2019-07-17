package com.jukkaikavalko.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button myButton;
    private int number = 0;

    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "OnCreate Called", Toast.LENGTH_LONG).show();

        myButton = findViewById(R.id.bShowNextActivityID);

        myButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                number += 1;
                intent.putExtra("MagicNumber", number);
                intent.putExtra("Message", "Hello from " + number + ". SPACE!");
                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    // Expect Result. NOBODY EXPECTS THE SPANISH INQUISITION.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK ){
                String result = data.getStringExtra("ReturnData");

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
        Toast.makeText(MainActivity.this, "OnPostResume Called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(MainActivity.this, "OnStart Called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(MainActivity.this, "OnStop Called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "OnDestroy Called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(MainActivity.this, "OnPause Called", Toast.LENGTH_LONG).show();
    }
}
