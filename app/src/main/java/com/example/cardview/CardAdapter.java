package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context mContext;
    private List<Card> mCardList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            imageView = (ImageView)view.findViewById(R.id.card_image);
            textView = (TextView)view.findViewById(R.id.card_name);
        }
    }
    public CardAdapter(List<Card> cardList){
        mCardList = cardList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Card card = mCardList.get(position);
        holder.textView.setText(card.getName());
        Glide.with(mContext).load(card.getImagedId()).into(holder.imageView);
    }
    @Override
    public  int getItemCount(){
        return mCardList.size();
    }

}
