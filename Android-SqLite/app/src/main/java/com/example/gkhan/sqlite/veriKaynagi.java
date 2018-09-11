package com.example.gkhan.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gökhan on 24.07.2017.
 */

public class veriKaynagi {
    SQLiteDatabase db;
    sqlite_katmani mydb;
    public veriKaynagi(Context c){
        mydb = new sqlite_katmani(c);
    }
    public List<kullanici> ac() {
        db = mydb.getWritableDatabase();
        return null;
    }
    public void kapa(){
        mydb.close();
    }
    public void kullaniciOlustur(kullanici k){
        /*String isim = "ali demir";
        kullanici k = new kullanici();
        k.setIsim(isim);*/
        ContentValues val = new ContentValues();
        val.put("isim",k.getIsim());
        db.insert("kullanici",null,val);
    }
    public void sil(kullanici k){
        int id = k.getId();
        db.delete("kullanici","id="+id,null);
    }
    public List<kullanici> listele(){
        String kolonlar [] = {"id","isim"};
        List<kullanici> liste = new ArrayList<kullanici>();
        Cursor cr = db.query("kullanici",kolonlar,null,null,null,null,null);
        cr.moveToFirst();
        while(!cr.isAfterLast()){
            int id = cr.getInt(0);
            String isim = cr.getString(1);
            String eleman = ""+id+"-"+isim;
            kullanici k = new kullanici(isim,id);
            liste.add(k);
            cr.moveToNext();
        }
        cr.close();
        return liste;
    }
}
