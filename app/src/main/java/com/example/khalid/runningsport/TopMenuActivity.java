package com.example.khalid.runningsport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class TopMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){ //Bila menekan tombol back maka akan kembali ke MainActivity.xml
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickPesan1(View v){
        Intent i = new Intent(this, ConverseActivity.class);
        startActivity(i);
    }
    public void onClickPesan2(View v){
        Intent i = new Intent(this, AdidasActivity.class);
        startActivity(i);
    }
    public void onClickPesan3(View v){
        Intent i = new Intent(this, ReebokActivity.class);
        startActivity(i);
    }
    public void onClickPesan4(View v){
        Intent i = new Intent(this, NIKEActivity.class);
        startActivity(i);
    }
    public void onClickPesan5(View v){
        Intent i = new Intent(this, DiadoraActivity.class);
        startActivity(i);
    }

}

