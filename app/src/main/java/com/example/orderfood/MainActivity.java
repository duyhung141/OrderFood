package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.orderfood.databinding.ActivityMainBinding;

import com.example.orderfood.food.adapter.FoodAdapter;
import com.example.orderfood.food.model.Food;
import com.example.orderfood.food.model.FoodRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    RecyclerView foodRecycleView;
    FoodAdapter foodAdapter;
//    FoodRepository foodRepository;
    private ArrayList<Food> foods = new ArrayList<>();

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        setSupportActionBar(binding.toolbar);

        setContentView(R.layout.activity_main);

        foodRecycleView = findViewById(R.id.rvFood);
        for (int i = 0; i < 50; i++) {
            String input = String.format("%.2f",new Random().nextFloat() * 1000);
            input = input.replace(",", ".");
            float number = Float.parseFloat(input);
            Food f = new Food(i, "Food " + i, number);

            int resID = getResId("food", R.drawable.class);
            Uri imgUri = getUri(resID);
            f.setImage(imgUri);
            foods.add(f);
        }
        foodAdapter = new FoodAdapter(foods, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        foodRecycleView.setAdapter(foodAdapter);
        foodRecycleView.setLayoutManager(gridLayoutManager);

    }
    public Uri getUri (int resId){
        return Uri.parse("android.resource://"  + this.getPackageName().toString() + "/" + resId);
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (id == R.id.menu_cart){
//            Log.d("this","cart show here");
//            Intent intent = new Intent(this, CartActivity.class);
//            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}