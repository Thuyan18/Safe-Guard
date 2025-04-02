package com.hungn.safeliving;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.AlertViewHolder> {

    private Context context;
    private List<AlertItem> alertItems;

    public AlertAdapter(Context context, List<AlertItem> alertItems) {
        this.context = context;
        this.alertItems = alertItems;
    }

    @NonNull
    @Override
    public AlertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_alert, parent, false);
        return new AlertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertViewHolder holder, int position) {
        AlertItem item = alertItems.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvDescription.setText(item.getDescription());

        // Đặt màu cho hình tròn
        if (item.getType().equals("MUA")) {
            holder.circleView.setBackgroundResource(R.drawable.circle_green);
        } else {
            holder.circleView.setBackgroundResource(R.drawable.circle_beige);
        }
    }

    @Override
    public int getItemCount() {
        return alertItems.size();
    }

    public static class AlertViewHolder extends RecyclerView.ViewHolder {
        View circleView;
        TextView tvTitle, tvAuthor, tvDescription;

        public AlertViewHolder(@NonNull View itemView) {
            super(itemView);
            circleView = itemView.findViewById(R.id.circleView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}