package com.example.habtracker20;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final TextView dayOfMonth;
    private final com.example.habtracker20.CalendarAdapter.OnClickListener onClickListener;

    public CalendarViewHolder(@NonNull View itemView, com.example.habtracker20.CalendarAdapter.OnClickListener onClickListener) {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onClickListener = onClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onClickListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
