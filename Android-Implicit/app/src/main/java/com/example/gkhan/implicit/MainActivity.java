package com.example.gkhan.implicit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView resim;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        Bitmap bm = (Bitmap) b.get("data");
        resim.setImageBitmap(bm);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resim = (ImageView) findViewById(R.id.imageView);
        Button call = (Button) findViewById(R.id.ara);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calling = new Intent(Intent.ACTION_DIAL);
                calling.setData(Uri.parse("tel:0123456789"));
                startActivity(calling);
            }
        });
        Button camera = (Button) findViewById(R.id.kamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cam,1);
                //startActivity(cam);

            }
        });
    }
}
