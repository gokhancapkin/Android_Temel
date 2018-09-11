package com.example.gkhan.hafizaoyun;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;


public class Oyun extends AppCompatActivity {
    int sonKart=0;
    int skor;
    int hata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        Intent m_oyun = getIntent();
        String oName = m_oyun.getStringExtra("maintxt");
        TextView tv = (TextView) findViewById(R.id.yaz);
        tv.setText(oName);
        GridLayout gL = (GridLayout) findViewById(R.id.kartlarGl);
        kart kartlar[] = new kart[16];
        for(int i=1;i<=16;i++){
            kartlar[i-1] = new kart(this,i);
            kartlar[i-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k =(kart)v;
                    k.cevir();
                    TextView stat = (TextView) findViewById(R.id.yaz);
                    if(sonKart > 0){
                        final kart k2 =(kart) findViewById(sonKart);
                        if(k2.onId == k.onId && k2.getId() !=k.getId()){
                            k.cevrilme = false;
                            k2.cevrilme = false;

                            skor++;

                            stat.setText("Skor = "+skor+"\nHata"+hata);
                            if(skor == 8){

                            }
                        }
                        else {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k.cevir();
                                    k2.cevir();
                                }
                            },500);

                            sonKart = 0;
                            hata++;
                            stat.setText("Skor = "+skor+"\nHata"+hata);
                        }
                    }
                    else{
                        sonKart = k.getId();
                    }
                }
            });
        }
        //Karıştır
        for (int i=0;i<16;i++){
            int random = (int)(Math.random()*16);
            kart k = kartlar[random];
            kartlar[random] = kartlar[i];
            kartlar[i]=k;
        }
        for (int x=0;x<16;x++){
            gL.addView(kartlar[x]);
        }
    }
}
