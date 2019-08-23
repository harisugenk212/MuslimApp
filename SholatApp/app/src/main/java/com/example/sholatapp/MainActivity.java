package com.example.sholatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_jadwalsholat = findViewById(R.id.tv_jadwalsholat);
        TextView tv_produkhalal = findViewById(R.id.tv_produk_halal);
        TextView tv_doaharian = findViewById(R.id.tv_doa_harian);


        tv_jadwalsholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ijadwalsholat = new Intent(MainActivity.this, jadwalsholat.class);
                startActivity(ijadwalsholat);
            }
        });

        tv_produkhalal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iprodukhalal = new Intent(MainActivity.this, HalalApp.class);
                startActivity(iprodukhalal);
            }
        });

        tv_doaharian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idoaharian = new Intent(MainActivity.this, DoaHarianActivity.class);
                startActivity(idoaharian);
            }
        });
    }
}