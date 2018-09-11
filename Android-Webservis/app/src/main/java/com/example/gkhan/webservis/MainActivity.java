package com.example.gkhan.webservis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.text);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("");
                new arkaPlan().execute("http://192.168.100.52:8000");
            }
        });
    }
    class arkaPlan extends AsyncTask<String,String,String> {
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader br = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is));
                String satir;
                String dosya = "";
                while ((satir = br.readLine()) != null) {
                    Log.d("satir:", satir);
                    dosya += satir;
                }
                return dosya;
            } catch (Exception e) {
                e.printStackTrace();
                return "hata";

            }

        }
        protected void onPostExecute(String s){
            Log.d("postExe",s);
            try{
                JSONObject jo = new JSONObject(s);
            }
            catch (Exception e ){
                e.printStackTrace();
            }

            tv.setText(s);
        }
    }
}
