package com.example.gkhan.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gökhan on 24.07.2017.
 */

public class sqlite_katmani extends SQLiteOpenHelper {

    public sqlite_katmani(Context c){
        super(c,"kullanici",null,1);
    }
    public void onCreate(SQLiteDatabase db){
        String sql = "create table kullanici ( id integer primary key autoincrement, isim text not null )";
        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db,int eski,int yeni){
        db.execSQL("drop table if exist kullanici");
    }
}
