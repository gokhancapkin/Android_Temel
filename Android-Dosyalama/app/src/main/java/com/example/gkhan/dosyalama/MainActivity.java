package com.example.gkhan.dosyalama;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DOSYAYA YAZIP OKUMA
        /*try {
            FileOutputStream yazma = openFileOutput("dosya", Context.MODE_PRIVATE);
            String mesaj = "Yazıldı";
            yazma.write(mesaj.getBytes());
            yazma.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream okuma = openFileInput("dosya");
            InputStreamReader inp = new InputStreamReader(okuma);
            BufferedReader br = new BufferedReader(inp);
            TextView txt = (TextView) findViewById(R.id.yaz);
            txt.setText(br.readLine());
            okuma.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }*/
        try{
            Resources r = getResources();
            InputStream is = r.openRawResource(R.raw.deneme);
            Scanner s = new Scanner(is);
            TextView dosya = (TextView) findViewById(R.id.yaz);
            String str = "";
            //dosya.setText(s.next());// tek kelime okur
            while(s.hasNext()){
                str +=" "+s.next();
            }
            dosya.setText(str);


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
