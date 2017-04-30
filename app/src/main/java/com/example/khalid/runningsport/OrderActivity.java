package com.example.khalid.runningsport;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    RadioGroup mRadioGroup;
    RadioButton mRadioItem1, mRadioItem2, mRadioItem3;
    String item = null;
    Context mContext;
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>(); //membuat array list
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = getApplicationContext();
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        // radio
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioItem1 = (RadioButton) findViewById(R.id.mRadioItem1);
        mRadioItem2 = (RadioButton) findViewById(R.id.mRadioItem2);
        mRadioItem3 = (RadioButton) findViewById(R.id.mRadioItem3);
        // spinner
        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("Adidas Neo");
        mListMenu.add("Adidas Samba");
        mListMenu.add("Adidas Ultra Boost");
        mListMenu.add("Adidas Yeezy");
        mListMenu.add("Adidas ZX");
        mListMenu.add("NIKE Air");
        mListMenu.add("NIKE Free");
        mListMenu.add("NIKE Lunar");
        mListMenu.add("NIKE View");
        mListMenu.add("NIKE Zoom");
        mListMenu.add("Reebok gl6000");
        mListMenu.add("Reebok Global Royal");
        mListMenu.add("Reebok Hexalite");
        mListMenu.add("Reebok Realflex");
        mListMenu.add("Reebok Zigtech");
        mListMenu.add("Converse All Star Hitam");
        mListMenu.add("Converse All Star Abu - Abu");
        mListMenu.add("Converse All Star Putih garis Merah");
        mListMenu.add("Converse All Star Hitam garis Merah");
        mListMenu.add("Converse All Star Custom");
        mListMenu.add("Diadora N6100");
        mListMenu.add("Diadora Swan");
        mListMenu.add("Diadora Shape 3 Blue");
        mListMenu.add("Diadora Blueshield");
        mListMenu.add("Diadora Blueshield W Clay");//memasukan info ke spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);
    }
    public void onClickOrder(View view) { //hanya memilih salah satu radiobox dan mendapatkan text untuk item
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.mRadioItem1:
                item = mRadioItem1.getText().toString();
                break;
            case R.id.mRadioItem2:
                item = mRadioItem2.getText().toString();
                break;
            case R.id.mRadioItem3:
                item = mRadioItem3.getText().toString();
                break;
    }
        String to = "luthfikhalid81@gmail.com";
        String subject = mTextNama.getText().toString();
        String message = "Saya pesan sepatu "
                + mSpinnerMenu.getSelectedItem()
                + " sebanyak "
                + mTextQty.getText()
                + " buah, seharga "
                + mTextHarga.getText()
                + ", dengan Type Shoes "
                + item;

        Intent email = new Intent(Intent.ACTION_SEND); //order email
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Kirim email dengan"));
    }
    public void onClickPlus(View view) {
        harga = harga + 5; //logic tombol >
        qty = qty + 1;
        mTextQty.setText(qty + "");
        mTextHarga.setText("$" + harga);
    }

    public void onClickMin(View view) { //logic button <
        if (harga != 0) {
            harga = harga - 5;
            qty = qty - 1;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        } else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty + "");
            mTextHarga.setText("$" + harga);
        }
    }

    public void onClickReset(View v) {
        harga = 0; //logic reset button
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("$" + harga);
        mTextQty.setText(qty + "");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}

