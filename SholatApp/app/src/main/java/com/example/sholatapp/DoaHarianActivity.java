package com.example.sholatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DoaHarianActivity extends AppCompatActivity {
    private List_Surat_Adapter mAdapter;
    private ArrayList<Surat> mListSurat;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_harian);

        recyclerView = (RecyclerView)findViewById(R.id.recyeler_view_doa_harian);
        progressBar = findViewById(R.id.progress_bar_doa_harian);

        mListSurat = new ArrayList<Surat>();
        mAdapter = new List_Surat_Adapter(mListSurat);

        loadData();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new
                DividerItemDecoration(this,
                mLayoutManager.getOrientation()));
        recyclerView.setAdapter(mAdapter);
    }

    private void loadData() {
        try {
            ClientAsyncTask3 task = new ClientAsyncTask3(this, new
                    ClientAsyncTask3.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(String result) {
                            Log.d("SuratData", result);
                            try {
                                JSONObject jsonObj = new JSONObject(result);
                                JSONArray jsonArray = jsonObj.getJSONArray("hasil");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject obj = jsonArray.getJSONObject(i);
                                    Surat surat = new Surat();
                                    surat.nama_surat = obj.getString("nama");
                                    surat.asma =
                                            obj.getString("asma");
                                    surat.ayat =
                                            obj.getString("ayat");
                                    surat.diturunkan_di =
                                            obj.getString("type");
                                    surat.arti =
                                            obj.getString("arti");

                                    mListSurat.add(surat);
                                }
                                mAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            task.setmProgress(this.progressBar);
            task.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
