package com.example.orderfood;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.orderfood.table.RecyclerViewTableAdapter;
import com.example.orderfood.table.Table;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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

//        prepareTableListData();
    }



    private void prepareTableListData() {
        Table table = new Table("Mulord", R.drawable.mulord1);
        tableList.add(table);
    }
}



//package com.example.orderfood.user
//
//        import android.os.Bundle
//        import androidx.appcompat.app.AppCompatActivity
//        import androidx.recyclerview.widget.RecyclerView
//        import com.example.orderfood.table.RecyclerViewTableAdapter
//        import com.example.orderfood.table.Table
//
//class MainActivityy : AppCompatActivity() {
//private var recyclerView : RecyclerView? = null
//private var recyclerViewTableAdapter : RecyclerViewTableAdapter? = null
//private var tablelist = mutableListOf<Table>()
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        tablelist = ArrayList()
//
//        recyclerView = findViewById<View>(R.id.rvTableLists) as RecyclerView
//        recyclerViewTableAdapter = RecyclerViewTableAdapter(this@MainActivityy,tablelist)
//        val layoutManager : RecyclerView.LayoutManager = GirdLayoutManager(this, 2)
//        recyclerView!!.layoutManager = layoutManager
//        recyclerView!!.adapter = recyclerViewTableAdapter
//
//        prepareTableListData()
//        }
//private fun prepareTableListData(){
//        var table = Table("Mulord", R.drawable.mulord)
//        tablelist.add(table)
//        }
//        }