package com.example.nodalalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;


import java.util.ArrayList;

public class Food extends AppCompatActivity {
     RecyclerView recyclerView;
     ArrayList<ModelFood> foodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        recyclerView=findViewById(R.id.recycler);

        foodList=new ArrayList<>();
        foodList.add(new ModelFood(R.drawable.pasta,"Pasta","Italiyan", "190₹"));
        foodList.add(new ModelFood(R.drawable.deserts,"Deserts","Roman","123₹"));
        foodList.add(new ModelFood(R.drawable.icecream,"Icecream","Europe","330₹"));
        foodList.add(new ModelFood(R.drawable.strawberries,"Strawberries","Chinese","110₹"));
        foodList.add(new ModelFood(R.drawable.vegburger,"VegBurger","Indian","250₹"));
        foodList.add(new ModelFood(R.drawable.vegetablesalad,"Vegsalad","US","240₹"));
        foodList.add(new ModelFood(R.drawable.chickenburger,"Chicken Burger","Great Britian","240₹"));
        foodList.add(new ModelFood(R.drawable.frenchtoast,"Pasta","Eastern Europe","30₹"));
        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutmanager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutmanager);
        Foodadapter adapter=new Foodadapter(this,foodList);
        recyclerView.setAdapter(adapter);



    }
}
