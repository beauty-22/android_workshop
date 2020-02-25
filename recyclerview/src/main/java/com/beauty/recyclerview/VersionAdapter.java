package com.beauty.recyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionsHolder>
{
    private Context context;
    private List<AndroidVersion> list;
    public  VersionAdapter(Context context,List<AndroidVersion> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public VersionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return  new VersionsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VersionsHolder holder, int position) {
        holder.getName().setText(list.get(position).getName());
        holder.getImage().setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VersionsHolder extends RecyclerView.ViewHolder{
        public VersionsHolder(@NonNull View itemView){
            super(itemView);
        }

        TextView getName(){
            return  itemView.findViewById(R.id.textView);

        }
        ImageView getImage(){
            return itemView.findViewById(R.id.ImageView);
        }
    }
}
