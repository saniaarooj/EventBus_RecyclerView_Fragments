package com.example.salman.assignment_test;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Salman on 10/15/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {

    Gson gson;
    ImageView img;
    Button btn;
    View view1;
    FragmentActivity context;
    ArrayList<Contact> info;


    public CustomAdapter(FragmentActivity context, ArrayList<Contact> info) {

        this.context = context;
        this.info = info;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view1 = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        myViewHolder vh = new myViewHolder(view1);
        return vh;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        Contact c = info.get(position);
        holder.t1.setText(c.getName().toString());
        holder.t2.setText(c.getEmail().toString());
        holder.t3.setText(c.getPhone().toString());
        Picasso.with(context).load("http://www.abbieterpening.com/wp-content/uploads/2013/10/profile-pic-round-200px.png").resize(160, 160).into(img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.remove(position);
                Toast.makeText(context, "Contact Removed Successfully", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }


        });
        gson = new Gson();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = gson.toJson(info.get(position));
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("MyObjectString",str);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView t1;
        TextView t2;
        TextView t3;

        public myViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name);
            t2 = (TextView) itemView.findViewById(R.id.email);
            t3 = (TextView) itemView.findViewById(R.id.phone);
            img = (ImageView) itemView.findViewById(R.id.profilePic);
            btn = (Button) itemView.findViewById(R.id.remove);

        }
    }
}