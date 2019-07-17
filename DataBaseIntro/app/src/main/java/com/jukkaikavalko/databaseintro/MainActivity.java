package com.jukkaikavalko.databaseintro;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // Insert contacts
        Log.d("Insert: ", "Inserting...");

        // Next line doesn't work
        db.addContact(new Contact("Jukka", "0440786121"));
        db.addContact(new Contact("John", "34"));
        db.addContact(new Contact("Vilja", "34324"));

        // Read them back
        Log.d("Reading: ", " Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        // Get 1 contact
        Contact oneContact = db.getContact(1);
        //Log.d("One Contact: ", "Name: " +oneContact.getName() + "Phone: " + oneContact.getPhoneNumber());


        // foreach
        for (Contact c : contactList){
            String log = "ID: " + c.getId() + ", Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();
            Log.d("Contact: ", log);
        }


    }
}
