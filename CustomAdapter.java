package com.example.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    private ArrayList<DataModel> dataSet;
    private final RecycleViewInterface recycleViewInterface;

    public CustomAdapter(Context context,ArrayList<DataModel> dataSet,RecycleViewInterface recyclerViewInterface) {
        this.context = context;
        this.dataSet = dataSet;
        this.recycleViewInterface = recyclerViewInterface;    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout , parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view,recycleViewInterface);

        return myViewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {
        TextView textViewName = viewHolder.textViewName;
        //TextView textViewVersion = viewHolder.textViewVersion;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewName;
        //TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder (View itemView, RecycleViewInterface recyclerViewInterface )
        {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            textViewName = ( TextView) itemView.findViewById(R.id.textViewName);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){
                            View v = view.findViewById(R.id.yuvalFragmentHolder);
                            recyclerViewInterface.onItemClick(position,view);

                        }
                    }
                }
            });

        }
    }
}

