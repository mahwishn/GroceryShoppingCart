package com.example.dell_i5.groceryshopping.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell_i5.groceryshopping.*;
import com.example.dell_i5.groceryshopping.Interface.ItemClickListener;


/**
 * Created by Dell-i5 on 01/05/2018.
 */

public class foodviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView food_Name;
    public ImageView food_Image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public foodviewholder(View itemView) {
        super(itemView);
        food_Name = (TextView)itemView.findViewById(R.id.food_name);
        food_Image = (ImageView)itemView.findViewById(R.id.food_image);


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);



    }
}
