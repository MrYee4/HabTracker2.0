package com.example.habtracker20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder>{

    /*
    This class is used to use RecyclerView
    Taken from the video: https://www.youtube.com/watch?v=jTL6EDvrjn8

    Connected to item_style.xml
    Connected to viewTasks.java
    Connected to Task.java
     */

    Context context;
    ArrayList<Task> myTask;

    public DoesAdapter(Context c, ArrayList<Task> sf) {
        context = c;
        myTask = sf;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_style,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.titledoes.setText(myTask.get(position).getName());
        myViewHolder.datedoes.setText((CharSequence) myTask.get(position).getTime());
        myViewHolder.descdoes.setText(myTask.get(position).getNotes());

    }

    @Override
    public int getItemCount() {
        return myTask.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titled);
            descdoes = (TextView) itemView.findViewById(R.id.desd);
            datedoes = (TextView) itemView.findViewById(R.id.dated);

        }
    }
}