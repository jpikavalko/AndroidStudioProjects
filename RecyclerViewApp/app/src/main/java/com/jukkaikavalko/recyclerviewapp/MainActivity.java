package com.jukkaikavalko.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ListItem pyllyItem = new ListItem("Pylly", "Kaksipakarainen");
        listItems.add(pyllyItem);

        for (int i = 0; i < 10; i++)
        {
            ListItem item = new ListItem("Item" + (i+1), "Description");
            listItems.add(item);
        }

        adapter = new MyAdapter(this, listItems);

        recyclerView.setAdapter(adapter);
    }
}
