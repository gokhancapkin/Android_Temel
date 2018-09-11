package com.example.gkhan.hafizaoyun;

/**
 * Created by Gökhan on 18.07.2017.
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;


public class kart extends android.support.v7.widget.AppCompatButton {

    boolean acikmi=false;
    boolean cevrilme = true;
    int resimId;
    int bgId;
    Drawable bg;
    Drawable on;
    int onId=R.drawable.arka;
    public kart(Context context,int id) {
        super(context);
        setId(id);
        bgId = R.drawable.arka;


        if(id%8==0)
            onId=R.drawable.kupa;
        if(id%8==1)
            onId=R.drawable.sinek;
        if(id%8==2)
            onId=R.drawable.karo;
        if(id%8==3)
            onId=R.drawable.maca;
        if(id%8==4)
            onId=R.drawable.as;
        if(id%8==5)
            onId=R.drawable.kiz;
        if(id%8==6)
            onId=R.drawable.vale;
        if(id%8==7)
            onId=R.drawable.bosluk;
        bg =AppCompatDrawableManager.get().getDrawable(context,bgId);
        on = AppCompatDrawableManager.get().getDrawable(context,onId);
        setBackground(bg);
    }
    public void cevir(){
        if(cevrilme) {
            if (!acikmi) {
                setBackground(on);
                acikmi = true;
            } else {
                setBackground(bg);
                acikmi = false;
            }
        }
    }
}
