package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import com.example.orderfood.food.adapter.FoodAdapter;
import com.example.orderfood.food.model.Food;
import com.example.orderfood.food.model.FoodRepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView foodRecycleView;
    FoodAdapter foodAdapter;
//    FoodRepository foodRepository;
    ArrayList<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

//        LinearLayoutManager llm = new LinearLayoutManager(this);
        foodRecycleView.setAdapter(foodAdapter);
        foodRecycleView.setLayoutManager(gridLayoutManager);

//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
//        rvProduct.setLayoutManager(mLayoutManager);
//
//        ProductsAdapter rvAdapter  = new ProductsAdapter(this, this.productRepository.getProductList());
//        rvProduct.setAdapter(rvAdapter);
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

//    private void initData() {
//        ArrayList<Food> foods = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            String input = String.format("%.2f",new Random().nextFloat() * 1000);
//            input = input.replace(",", ".");
//            float number = Float.parseFloat(input);
//            Food f = new Food(i, "Food " + i, number);
//            foods.add(f);
//        }
//        this.foodRepository= new FoodRepository(foods);
//    }
}