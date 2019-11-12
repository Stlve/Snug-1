package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private DrawerLayout mdrawerLayout;
    private Card[] cards = {new Card("apple",R.drawable.apple),new Card("cherry",R.drawable.cherry),new Card("bananan",R.drawable.cherry)};
    private List<Card> cardList = new ArrayList<>();
    private CardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //上面条条隐藏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initCards();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CardAdapter(cardList);
        recyclerView.setAdapter(adapter);
}
    private void initCards(){
        cardList.clear();
        for (int i=0;i<4;i++){
            Random random = new Random();
            int index = random.nextInt(cards.length);
            cardList.add(cards[index]);
        }
    }
}
