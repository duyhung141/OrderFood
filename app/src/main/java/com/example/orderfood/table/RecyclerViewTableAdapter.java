package com.example.orderfood.table;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfood.MainActivity;
import com.example.orderfood.R;

import java.util.List;

public class RecyclerViewTableAdapter extends RecyclerView.Adapter<RecyclerViewTableAdapter.MyViewHolder> {
    private MainActivity getActivity;
    private List<Table> tableList;

    public RecyclerViewTableAdapter(MainActivity activity, List<Table> tables) {
        getActivity = activity;
        tableList = tables;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTableTitle;
        public ImageView ivTableImg;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);
            tvTableTitle = view.findViewById(R.id.tvTableTitle);
            ivTableImg = view.findViewById(R.id.ivTableImg);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_table, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,  int position) {
        Table table = tableList.get(position);
        holder.tvTableTitle.setText(table.getTitle());
        holder.ivTableImg.setImageResource(table.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
//    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
//        final  Food f = foods.get(position);
//        String sFoodName = f.getName();
//        holder.txtFoodName.setText(sFoodName);
//        holder.txtPrice.setText(""+f.getPrice());
//        holder.idFoodImage.setImageURI(f.getImage());
//
////        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                addButtonClick(view, p);
////            }
////        });
//    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

}