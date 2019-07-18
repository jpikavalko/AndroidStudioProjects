package com.jukkaikavalko.grocerylist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.jukkaikavalko.grocerylist.Data.DatabaseHandler;
import com.jukkaikavalko.grocerylist.Model.Grocery;
import com.jukkaikavalko.grocerylist.R;

public class MainActivity extends AppCompatActivity
{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText groceryItem;
    private EditText quantity;
    private Button saveButton;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                createPopUpDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createPopUpDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup, null);

        groceryItem = view.findViewById(R.id.groceryItem);
        quantity = view.findViewById(R.id.groceryQty);
        saveButton = view.findViewById(R.id.saveButton);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Todo: Save to db
                //Todo: go to next screen

                if (!groceryItem.getText().toString().isEmpty() && !quantity.getText().toString().isEmpty()){
                    saveGroceryToDB(view);
                }

            }
        });
    }

    private void saveGroceryToDB(View view)
    {
        Grocery grocery = new Grocery();

        String newGrocery = groceryItem.getText().toString();
        String newGroceryQty = quantity.getText().toString();

        grocery.setName(newGrocery);
        grocery.setQuantity(newGroceryQty);

        //Save to database
        db.addGrocery(grocery);

        Snackbar.make(view, "Item Saved!", Snackbar.LENGTH_LONG).show();
        //Log.d("Item added ID: ", String.valueOf(db.getGroceriesCount()));
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                dialog.dismiss();
                // start a new activity
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        }, 800);
    }
}
