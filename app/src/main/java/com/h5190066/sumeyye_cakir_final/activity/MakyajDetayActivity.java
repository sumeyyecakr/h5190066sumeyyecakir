package com.h5190066.sumeyye_cakir_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190066.sumeyye_cakir_final.R;
import com.h5190066.sumeyye_cakir_final.model.MakyajModel;
import com.h5190066.sumeyye_cakir_final.util.Constants;
import com.h5190066.sumeyye_cakir_final.util.GlideUtil;
import com.h5190066.sumeyye_cakir_final.util.ObjectUtil;


public class MakyajDetayActivity extends AppCompatActivity {

    ImageView imgKapakAlani;
    TextView txtBaslik,txtKullanimAlani,txtRenkSecenegi,txtAciklama;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makyaj_detay);
        init();



    }
    private void init(){

        String tasinanMakyajString=getIntent().getStringExtra(Constants.TIKLANAN_MAKYAJ_TASINANIN_BASLIGI);
        MakyajModel makyajModel= ObjectUtil.jsonStringToMakyaj(tasinanMakyajString);

        imgKapakAlani=findViewById(R.id.imgKapakAlani);
        txtBaslik=findViewById(R.id.txtBaslik);
        txtAciklama=findViewById(R.id.txtAciklama);
        txtKullanimAlani=findViewById(R.id.txtKullanimAlani);
        txtRenkSecenegi=findViewById(R.id.txtRenkSecenegi);


        txtBaslik.setText((makyajModel.getAdi()));
        txtKullanimAlani.setText(makyajModel.getKullanimAlani());
        txtAciklama.setText((makyajModel.getAciklama()));
        txtRenkSecenegi.setText((makyajModel.getRenkSecenekleri()));


        GlideUtil.resmiIndiripGoster(getApplicationContext(),makyajModel.getBannerUrl(),imgKapakAlani);

    }
}