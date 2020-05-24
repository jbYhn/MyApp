package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        final Button previous = findViewById(R.id.button);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });



        TextView body = findViewById(R.id.textView3);
        String joke  = intent.getStringExtra("joke");
        body.setText(joke);

     /*   ImageView img = findViewById(R.id.imageDetail);
        TextView quotVw = findViewById(R.id.quote);
        TextView name = findViewById(R.id.name);
        Intent intent = getIntent();
        String quote = intent.getStringExtra("quote");
        String character = intent.getStringExtra("character");
        String image = intent.getStringExtra("image");
        Picasso.get().load(image).into(img);
        quotVw.setText(quote);
        name.setText(character);

      */
    }



}
