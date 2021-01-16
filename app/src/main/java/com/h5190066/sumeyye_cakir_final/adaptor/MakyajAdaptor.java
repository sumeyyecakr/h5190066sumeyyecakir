package com.h5190066.sumeyye_cakir_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190066.sumeyye_cakir_final.R;
import com.h5190066.sumeyye_cakir_final.model.MakyajModel;
import com.h5190066.sumeyye_cakir_final.util.GlideUtil;


import java.util.List;

public class MakyajAdaptor extends RecyclerView.Adapter<MakyajViewHolder> {

    List<MakyajModel> makyajlar;
    Context context;
    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClik(int position);
    }
    public MakyajAdaptor(List<MakyajModel> makyajlar, Context context, OnItemClickListener listener) {
        this.makyajlar = makyajlar;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public MakyajViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_makyaj,parent,false);
        return new MakyajViewHolder(itemView,listener);
    }
    @Override
    public void onBindViewHolder(@NonNull MakyajViewHolder viewHolder, int position) {
        viewHolder.txtMakyajAdi.setText(makyajlar.get(position).getAdi());
        viewHolder.txtKullanimAlani2.setText(makyajlar.get(position).getKullanimAlani());
        viewHolder.txtRenkSecenegi2.setText(makyajlar.get(position).getRenkSecenekleri());
        GlideUtil.resmiIndiripGoster(context,makyajlar.get(position).getLogoUrl(),viewHolder.MakyajLogoimg);
    }
    @Override
    public int getItemCount() {
        return makyajlar.size();
    }
}