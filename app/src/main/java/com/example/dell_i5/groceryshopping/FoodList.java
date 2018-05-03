package com.example.dell_i5.groceryshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dell_i5.groceryshopping.Interface.ItemClickListener;
import com.example.dell_i5.groceryshopping.Model.food;
import com.example.dell_i5.groceryshopping.ViewHolder.foodviewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference foodList;
    String categoryId="";

    FirebaseRecyclerAdapter<food,foodviewholder>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);


        database=FirebaseDatabase.getInstance();
        foodList=database.getReference("Food");
        recyclerView=(RecyclerView)findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent()!=null)
            categoryId=getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty()&& categoryId !=null);
        {
            Loadlistfood(categoryId);
        }

    }

    private void Loadlistfood(String categoryId) {
        adapter=new FirebaseRecyclerAdapter<food, foodviewholder>(food.class,R.layout.food_item,foodviewholder.class,
                foodList.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(foodviewholder viewHolder, food model, int position) {
                viewHolder.food_Name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.food_Image);
                final  food local=model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodList.this, ""+local.getName(), Toast.LENGTH_SHORT).show();

                        Intent foodDetail = new Intent(FoodList.this,FoodDetail.class);
                        foodDetail.putExtra("FoodId",adapter.getRef(position).getKey());
                        startActivity(foodDetail);

                    }
                });

            }
        };
        Log.d("TAG",""+adapter.getItemCount());



        recyclerView.setAdapter(adapter);

    }
}
