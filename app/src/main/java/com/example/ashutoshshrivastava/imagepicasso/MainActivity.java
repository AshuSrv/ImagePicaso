package com.example.ashutoshshrivastava.imagepicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);

        String url = "https://alfahir.hu/sites/default/files/indexfotos/2018-05/cr7_bl.jpg";
        Float angle = 0f;
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
loadImageWithRotation(url,0f,imageView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_mennu, menu);
        return true;
    }
    String url = "https://alfahir.hu/sites/default/files/indexfotos/2018-05/cr7_bl.jpg";
    Float angle = 0f;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.rotate_right:
                loadImageWithRotation(url, 90f, imageView);
                return true;
            case R.id.rotate_left:
                loadImageWithRotation(url, -90f, imageView);
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }

    private void loadImageWithRotation(String url, Float rotation, ImageView imageView) {
        angle += rotation;
       Picasso.with(this)
                .load(url)
                .resize(2160, 1980)
                .rotate(angle)
                .into(imageView);
    }
}
