package com.example.helloandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        MainActivityWindow();
    }

    // Main Activity Window
    private void MainActivityWindow(){
        // Local variables
        final Button myButton1, myButton2, myButton3, myAlert;
        final TextView myText;
        final EditText myEditText;


        setContentView(R.layout.activity_main);

        // Main Activity
        myButton1 = findViewById(R.id.mButton1);
        myButton2 = findViewById(R.id.mButton2);
        myButton3 = findViewById(R.id.mButton3);
        myAlert = findViewById(R.id.alertButton);

        myText =  findViewById(R.id.mText);
        myEditText = findViewById(R.id.editText);

        // Submit Button
        myButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String enteredName;

                enteredName = myEditText.getText().toString();
                myText.setVisibility(View.VISIBLE);
                String te = getString( R.string.custom_text, enteredName);
                myText.setText(te);
            }
        });

        // Try Me Button
        myButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Changes the 'scene'
                TryMeWindow();
            }
        });

        // Radio Buttons
        myButton3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                RadioButtonsWindow();
            }
        });

        // Show Alert
        myAlert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AlertDialog.Builder alertDialog;
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                // Set Icon
                alertDialog.setIcon(android.R.drawable.star_big_on);
                // Set title
                alertDialog.setTitle(R.string.error_title);
                // Set message
                alertDialog.setMessage(R.string.error_message);
                // Set cancel button to false. Why?
                alertDialog.setCancelable(false);
                // Set positive button
                alertDialog.setPositiveButton(R.string.error_positive, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        // Exit dialog
                        //MainActivity.this.finish();
                        Toast.makeText(getBaseContext(), "You sick fuck", Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.setNegativeButton(R.string.error_negative, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        // Exit dialog
                        dialogInterface.cancel();
                        
                    }
                });

                // Create actual dialog
                AlertDialog dialog = alertDialog.create();

                // Show Dialog
                dialog.show();
            }
        });
    }

    private void TryMeWindow(){
        // Local variables
        final View tryMeView;
        final Button tryMeButton;
        final int[] colors = new int[]{Color.CYAN, Color.GREEN, Color.RED, Color.BLUE, Color.MAGENTA};

        setContentView(R.layout.tryme_exercise);

        tryMeButton = findViewById(R.id.bTryMe);
        tryMeView = findViewById(R.id.windowViewId);

        tryMeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int colorArrayLength = colors.length;
                Random rand = new Random();
                int randNum = rand.nextInt(colorArrayLength);
                tryMeView.setBackgroundColor(colors[randNum]);

                Log.d("Random", String.valueOf(randNum));
            }
        });


    }

    private void RadioButtonsWindow(){
        // Local variables
        final RadioGroup radioGroup;

        // Load layout
        setContentView(R.layout.layout_radiobuttons);

        radioGroup = findViewById(R.id.radioButtonsID);

        // Methods
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                final RadioButton rButtons = findViewById(i);

                switch (rButtons.getId()){
                    case R.id.yesID:
                        Log.d("RD", "Yes");
                        break;
                    case R.id.maybeID:
                        Log.d("RD", "Maybe");
                        break;
                    case R.id.noID:
                        Log.d("RD", "No");
                        break;
                }
            }
        });


    }

    // Example of how not to
    public void ShowText(View view){


    }
}
