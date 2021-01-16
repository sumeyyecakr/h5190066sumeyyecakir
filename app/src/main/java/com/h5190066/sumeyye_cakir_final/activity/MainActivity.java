package com.h5190066.sumeyye_cakir_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190066.sumeyye_cakir_final.R;
import com.h5190066.sumeyye_cakir_final.activity.ListeActivity;
import com.h5190066.sumeyye_cakir_final.util.AlertDialogUtil;
import com.h5190066.sumeyye_cakir_final.util.NetworkUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ucSaniyeBekleme();
    }

    public void ucSaniyeBekleme() {
        CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if(NetworkUtil.internetiKontrolEt(getApplicationContext()))
                {
                    Intent digerekranagecis=new Intent(getApplicationContext(),ListeActivity.class);
                    startActivity(digerekranagecis);
                    finish();
                }
                else
                {
                    InternetKontrol();
                }

            }
        };
        countDownTimer.start(); }

    public void InternetKontrol(){
        AlertDialogUtil.AlertUtil(MainActivity.this ,getResources().getString(R.string.internet_baglantisiyok),getResources().getString(R.string.internet_baglantisigerekli),getResources().getString(R.string.ayarlara_gitme),getResources().getString(R.string.app_kapat),getResources().getString(R.string.gosterilcekekranmain));
         }

}