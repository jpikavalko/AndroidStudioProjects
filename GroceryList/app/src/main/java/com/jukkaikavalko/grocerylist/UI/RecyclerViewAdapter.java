package com.jukkaikavalko.grocerylist.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jukkaikavalko.grocerylist.Model.Grocery;
import com.jukkaikavalko.grocerylist.R;
import com.jukkaikavalko.grocerylist.Util.Constants;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private Context context;
    private List<Grocery> groceryItems;

    public RecyclerViewAdapter(Context context, List<Grocery> groceryItems)
    {
        this.context = context;
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position)
    {
        Grocery grocery = groceryItems.get(position);

        viewHolder.groceryItemName.setText(grocery.getName());
        viewHolder.groceryQty.setText(grocery.getQuantity());
        viewHolder.dateAdded.setText(grocery.getDateItemAdded());
    }

    @Override
    public int getItemCount()
    {
        return groceryItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView groceryItemName;
        public TextView groceryQty;
        public TextView dateAdded;
        public Button editButton;
        public Button deleteButton;
        public int id;

        public ViewHolder(@NonNull View view, Context ctx)
        {
            super(view);

            context = ctx;

            groceryItemName = view.findViewById(R.id.name);
            groceryQty = view.findViewById(R.id.quantity);
            dateAdded = view.findViewById(R.id.dateAdded);

            editButton = view.findViewById(R.id.editButton);
            deleteButton = view.findViewById(R.id.deleteButton);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);

            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    // Go to next screen (details activity)

                }
            });
        }

        @Override
        public void onClick(View view)
        {
            switch (view.getId()){
                case R.id.editButton:

                    break;

                case R.id.deleteButton:

                    break;
            }
        }
    }
}
