package com.example.apirecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Post> postList;
    Context context;

    public MyAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder= new ViewHolder(view);
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,infoActivty.class);
//                intent.putExtra("title",  postList.get(viewHolder.getAdapterPosition()).getTitle());
//                intent.putExtra("body",  postList.get(viewHolder.getAdapterPosition()).getText());
                 intent.putExtra("body",  postList.get(viewHolder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }
    @Override
    public int getItemCount() {
        return postList.size();
    }
    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(postList.get(position).getTitle());
        holder.tvbody.setText(postList.get(position).getTitle());

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvbody;
        CardView card;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvTitle= itemView.findViewById(R.id.tvTitle);
            tvbody= itemView.findViewById(R.id.tvbody);
            card = itemView.findViewById(R.id.cardViewitem);
        }
    }
}
