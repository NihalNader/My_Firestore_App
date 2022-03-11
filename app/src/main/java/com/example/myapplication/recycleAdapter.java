package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder> {
//   private ArrayList<Users>productslist;
//public recycleAdapter(ArrayList<Users>productslist){
//    this.productslist=productslist;
//}


    Context context;
    ArrayList<Users> usersArrayList;

    public recycleAdapter(Context context, ArrayList<Users> usersArrayList) {
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public recycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View itemView = LayoutInflater.from(context).inflate(R.layout.list_items,parent,false);

return new MyViewHolder(itemView);
}

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.MyViewHolder holder, int position) {

        Users user=usersArrayList.get(position);

holder.name.setText(user.name);
        holder.address.setText(user.address);
        holder.phone.setText(user.phone);

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,address,phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textname);
            address=itemView.findViewById(R.id.textaddress);
            phone=itemView.findViewById(R.id.textphone);
        }


//        private TextView nameTxt;
//        public MyViewHolder(final View view){
//            super(view);
//            nameTxt=view.findViewById(R.id.textView3);
//
//        }
    }




}
