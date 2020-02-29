package com.beauty.retrofit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.beauty.retrofit.domain.DataItem;

import java.util.List;

public class EmployeeAdapter extends EmployeeAdapter.ViewHolder.Adapter<EmployeeAdapter.ViewHolder.VersionsHolder>
{
    private Context context;
    private List<DataItem> list;

    public EmployeeAdapter(Context context, List<DataItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.single_card2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        holder.getName().setText(list.get(position).getEmployeeName());
        holder.getAge().setText(list.get(position).getEmployeeAge());
        holder.getSalary().setText(list.get(position).getEmployeeSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        TextView getName(){
            return itemView.findViewById(R.id.txtName);
        }

        TextView getAge(){
            return itemView.findViewById(R.id.txtAge);
        }

        TextView getSalary(){
            return itemView.findViewById(R.id.txtSalary);
        }


    }

    /*private Context context;
    private List<AndroidVersion> list;
    private AlertDialog.Builder builder;
    private Activity activity;

    public EmployeeAdapter(Context context, List<AndroidVersion> list, Activity activity){
        this.context=context;
        this.list=list;
        this.activity=activity;
    }

    @NonNull
    @Override
    public VersionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_card,parent,false);
        return  new VersionsHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final VersionsHolder holder, final int position) {
        holder.getName().setText(list.get(position).getName());
        holder.getImage().setImageResource(list.get(position).getImage());
        holder.getName().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                builder=new AlertDialog.Builder(context);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();


                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
              /* Toast.makeText(context,"position:"+position+"Name:"+list.get(position).getName(),Toast.LENGTH_SHORT).show();
               Snackbar snackbar= Snackbar.make(holder.getLayout(),"position:"+position+"Name:"+list.get(position).getName(),Snackbar.LENGTH_SHORT);
               snackbar.show();
            }


    });
    }
    private void showDialog(){
        Dialog dialog=new Dialog(context);
        dialog.setContentView(R.layout.dialog_logout);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        Button btnYes=dialog.findViewById(R.id.btnYes);
        Button btnNo=dialog.findViewById(R.id.btnNo);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
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
        ConstraintLayout getLayout(){
            return itemView.findViewById(R.id.singleCardConstraint);
        }
    }*/
    }
