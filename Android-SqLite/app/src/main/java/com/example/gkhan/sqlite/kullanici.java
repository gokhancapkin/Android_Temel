package com.example.gkhan.sqlite;

/**
 * Created by Gökhan on 24.07.2017.
 */

public class kullanici {
    String isim;
    int id;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }
    public String toString(){
        return ""+id+"-"+isim;
    }
}
