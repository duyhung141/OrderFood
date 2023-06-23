package com.example.orderfood.table.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfood.MainActivity;
import com.example.orderfood.R;
import com.example.orderfood.table.model.Table;

import java.util.List;

public class RecyclerViewTableAdapter extends RecyclerView.Adapter<RecyclerViewTableAdapter.MyViewHolder> {
    private List<Table> tableList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Table table);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public RecyclerViewTableAdapter(MainActivity mainActivity, List<Table> tables) {
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

            ivTableImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                        onItemClickListener.onItemClick(tableList.get(position));
                    }
                }
            });

        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_table, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Table table = tableList.get(position);
        holder.tvTableTitle.setText(table.getTitle());
        holder.ivTableImg.setImageResource(table.getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Thực hiện sự kiện khi click vào CardView nếu cần
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }
}
