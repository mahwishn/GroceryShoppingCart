package com.example.dell_i5.groceryshopping.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell_i5.groceryshopping.Interface.ItemClickListener;
import com.example.dell_i5.groceryshopping.R;

/**
 * Created by Dell-i5 on 30/04/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;
    public MenuViewHolder(View itemView)
    {
        super(itemView);
        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);


        itemView.setOnClickListener(this);
    }

    public void setItemClickListner(ItemClickListener itemClickListner) {

    this.itemClickListener = itemClickListner;
    }

    @Override

    public void onClick(View view){
        itemClickListener.onClick(view,getAdapterPosition(),false);


    }
}
