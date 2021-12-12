package com.hust.emailinterface;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    List<EmailItem> emailList;
    Context mContext;
    Random rnd;

    public EmailAdapter(List<EmailItem> emailList, Context mContext) {
        this.emailList = emailList;
        this.mContext = mContext;
        rnd = new Random();
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        EmailItem item = emailList.get(position);
        String sender = item.getSender();
        String content = item.getContent();
        String time = item.getTime();

        holder.ava.setText(Character.toString(Character.toUpperCase(sender.charAt(0))));
        holder.ava.getBackground().setTint(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        holder.textViewSender.setText(sender);
        holder.textViewContent.setText(content);
        holder.textViewTime.setText(time);

    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    public class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView ava, textViewSender, textViewContent, textViewTime;
        ImageView star;


        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);

            ava = itemView.findViewById(R.id.ava);
            textViewSender = itemView.findViewById(R.id.textViewSender);
            textViewContent = itemView.findViewById(R.id.textViewContent);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            star = itemView.findViewById(R.id.star);

            star.setOnClickListener(v -> {
                star.setImageResource(R.drawable.star);
            });
        }
    }
}
