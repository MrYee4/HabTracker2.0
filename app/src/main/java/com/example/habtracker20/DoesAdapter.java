package com.example.habtracker20;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


    public DoesAdapter(Context c, ArrayList<Task> mt) {
        context = c;
        myTask = mt;
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


        myViewHolder.delHab.setOnClickListener(new View.OnClickListener() {
            @Override
            /* Connect with the database to remove permanently the Habits
            * Delete Habit source: https://www.youtube.com/watch?v=hyE3L2TVEvs&t=0s*/
            public void onClick(View v) {
                //myTask.get(position);
                myTask.remove(position);
                notifyDataSetChanged();
                Log.d("Action", "Habit Removed");

            }
        });

        myViewHolder.comphab.setOnClickListener(new View.OnClickListener() {
            @Override
            /* Connect with the database to remove permanently the Habits
             * Delete Habit source: https://www.youtube.com/watch?v=hyE3L2TVEvs&t=0s*/
            public void onClick(View v) {
                //myTask.get(position);
                myTask.remove(position);
                notifyDataSetChanged();
                Log.d("Action", "Habit Completed");

            }
        });


    }

    @Override
    public int getItemCount() {
        return myTask.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        Button delHab, comphab;

        TextView titledoes, descdoes, datedoes;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titled);
            descdoes = (TextView) itemView.findViewById(R.id.desd);
            datedoes = (TextView) itemView.findViewById(R.id.dated);

            delHab = itemView.findViewById(R.id.removehab);
            comphab = itemView.findViewById(R.id.comphab);

        }
    }

}
