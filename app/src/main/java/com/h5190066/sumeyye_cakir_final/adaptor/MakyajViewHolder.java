package com.h5190066.sumeyye_cakir_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190066.sumeyye_cakir_final.R;


public class MakyajViewHolder extends RecyclerView.ViewHolder {
    ImageView MakyajLogoimg;
    TextView txtMakyajAdi,txtRenkSecenegi2,txtKullanimAlani2;
    public MakyajViewHolder(@NonNull View cardView, MakyajAdaptor.OnItemClickListener listener) {
        super(cardView);
        MakyajLogoimg =cardView.findViewById(R.id.MakyajLogoimg);
        txtMakyajAdi =cardView.findViewById(R.id.txtMakyajAdi);
        txtRenkSecenegi2 =cardView.findViewById(R.id.txtRenkSecenegi2);
        txtKullanimAlani2 =cardView.findViewById(R.id.txtKullanimAlani2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClik(getAdapterPosition());
            }
        });
    }
}