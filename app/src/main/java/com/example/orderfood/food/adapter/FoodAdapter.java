package com.example.orderfood.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfood.R;
import com.example.orderfood.food.model.Food;
import com.example.orderfood.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private ArrayList<Food> foods ;
    private Context mContext;

    public FoodAdapter(ArrayList<Food> foods, Context mContext) {
        this.foods = foods;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_food, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        final  Food f = foods.get(position);
        String sFoodName = f.getName();
        holder.txtFoodName.setText(sFoodName);
        holder.txtPrice.setText(""+f.getPrice());
        holder.idIVSSImage.setImageURI(f.getImage());

//        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addButtonClick(view, p);
//            }
//        });
    }

//    private void addButtonClick(View view, Product p) {
////        Toast.makeText(view.getContext(),"click on item: "+ p.getName(), Toast.LENGTH_LONG).show();
//        cart.addCart(p);
//        showSnackbar(view, mContext.getString(R.string.add_product) + p.getName(), Snackbar.LENGTH_SHORT);
//    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtFoodName;
        public TextView txtPrice;
        public RelativeLayout relativeLayout;

        public ImageView ivAdd;
        public ImageView idIVSSImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtFoodName = (TextView)itemView.findViewById(R.id.txtNameFood);
            this.txtPrice = (TextView)itemView.findViewById(R.id.txtPriceFood);
            this.ivAdd = (ImageView)itemView.findViewById(R.id.ivAdd);
//            this.idIVSSImage = (ImageView)itemView.findViewById(R.id.idIVSSImage);
            this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);

        }
    }
}
