package com.example.sholatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class List_Surat_Adapter extends RecyclerView.Adapter<List_Surat_Adapter.SuratHolder> {
    private ArrayList<Surat> listsurat;

    public List_Surat_Adapter(ArrayList<Surat> listsurat) {
        this.listsurat = listsurat;
    }

    @NonNull
    @Override
    public List_Surat_Adapter.SuratHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SuratHolder(inflater.inflate(R.layout.ayat_pilihan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List_Surat_Adapter.SuratHolder holder, int position) {
        holder.mnamasurat.setText(listsurat.get(position).getNama_surat());
        holder.masma.setText(listsurat.get(position).getAsma());
        holder.mayat.setText(listsurat.get(position).getAyat());
        holder.mditurunkan.setText(listsurat.get(position).getDiturunkan_di());
        holder.marti.setText(listsurat.get(position).getArti());
    }

    @Override
    public int getItemCount() {
        return listsurat.size();
    }

    public class SuratHolder extends RecyclerView.ViewHolder {

        private TextView mnamasurat;
        private TextView masma;
        private TextView mayat;
        private TextView mditurunkan;
        private TextView marti;


        public SuratHolder(@NonNull View itemView) {
            super(itemView);
            mnamasurat = itemView.findViewById(R.id.tv_nama_surat);
            masma = itemView.findViewById(R.id.tv_asma);
            mayat = itemView.findViewById(R.id.tv_ayat_ke);
            mditurunkan = itemView.findViewById(R.id.tv_diturunkan_di);
            marti =itemView.findViewById(R.id.tv_arti);
        }
    }
}
