package com.example.cardview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private DrawerLayout mdrawerLayout;
    private Card[] cards = {new Card("和我说话",R.drawable.talkwithmeldpi),new Card("当前旅程",R.drawable.tripldpi),new Card("选择旅程",R.drawable.alltripldpi),new Card("成长回顾",R.drawable.conclusionldpi)};
    private List<Card> cardList = new ArrayList<>();
    private CardAdapter adapter;
    private ImageView head_photo;
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
        adapter.setRecyclerItemClickListener(new CardAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(int Position, List<Card> cardList) {
                if (Position==0){
                    Intent i = new Intent(MainActivity.this, Addevent.class);  // 进去MainActivity
                    startActivity(i);
                }
                if (Position==1){

                }
                if (Position==2){

                }
                if (Position==3){

                }
            }
        });
        head_photo = (ImageView)findViewById(R.id.head_photo);
        head_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, Addevent.class);  // 进去MainActivity
//                startActivity(i);
            }
        });

}
    private void initCards(){
        cardList.clear();
        for (int i=0;i<4;i++){
            cardList.add(cards[i]);
        }
    }


}
