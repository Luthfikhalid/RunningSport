package com.example.khalid.runningsport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DiadoraActivity extends AppCompatActivity {
    private ListView listitem;
    private String [] Shoes = new String[]{
            "Diadora N6100" , "Diadora SWAN" , "Diadora Shape 3 Blue" , "Diadora Blueshield" , "Diadora Blueshield W Clay"
    };
    //mendeklarasi ListView var dan menginisialisasi array tipe data string
    //langkah 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reebok);

        getSupportActionBar().setTitle("Brand Reebok");//menampilkan tittle atau judul di atas

        listitem = (ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> adabter = new ArrayAdapter<String>(DiadoraActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,  Shoes);

        /*
        langkah 2
        memformat data
         */

        listitem.setAdapter(adabter);
        //menset data di dalam listview

        //langkah 3
        listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DiadoraActivity.this, "Chooses : "+Shoes[position], Toast.LENGTH_LONG).show();

                //memanggil set on Item ClickListener untuk Listview, jadi jika salah satu item list view diklik akan
                //akan bereaksi menampilkan toast atau aksi lainya.
                //Step 4
            }
        });
    }
}
