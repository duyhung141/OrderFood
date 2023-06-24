package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.orderfood.table.adapter.RecyclerViewTableAdapter;
import com.example.orderfood.table.model.Table;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewTableAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewTableAdapter recyclerViewTableAdapter;
    private List<Table> tableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableList = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            String nameImage = "mulord" + i;
            int imageResId = getResources().getIdentifier(nameImage, "drawable", getPackageName());
            Table t = new Table("Table " + i, imageResId);
            tableList.add(t);
        }

        recyclerView = findViewById(R.id.rvTableList);
        recyclerViewTableAdapter = new RecyclerViewTableAdapter(this, tableList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewTableAdapter);

        recyclerViewTableAdapter.setOnItemClickListener(this);
//=======
//        setContentView(R.layout.checkout_activity);
//>>>>>>> origin/minhtuan
    }

    @Override
    public void onItemClick(Table table) {
        // Thực hiện chuyển trang khi click vào ảnh
        // Ví dụ:
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        startActivity(intent);
    }
}

