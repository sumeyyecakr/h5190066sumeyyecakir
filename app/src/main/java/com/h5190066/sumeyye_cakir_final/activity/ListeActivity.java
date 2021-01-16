package com.h5190066.sumeyye_cakir_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.h5190066.sumeyye_cakir_final.R;
import com.h5190066.sumeyye_cakir_final.adaptor.MakyajAdaptor;
import com.h5190066.sumeyye_cakir_final.model.MakyajModel;
import com.h5190066.sumeyye_cakir_final.network.Service;
import com.h5190066.sumeyye_cakir_final.util.AlertDialogUtil;
import com.h5190066.sumeyye_cakir_final.util.Constants;
import com.h5190066.sumeyye_cakir_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_ekrani);

        init();
        progressDialog = new ProgressDialog(ListeActivity.this);
        progressDialog.setMessage(getResources().getString(R.string.app_bekleyiniz));
        progressDialog.show();

    }

    private  void  init()
    {
        makyajlariGetir();
    }

    void  makyajlariGetir()
    {

        new Service().getServiceApi().makyajlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MakyajModel>>() {

                    List<MakyajModel> makyajlar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(@NonNull List<MakyajModel> makyajList) {
                        Log.e("RETROFIT","onNext : ");
                        makyajlar=makyajList;
                    }


                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                        progressDialog.dismiss();
                    }


                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");
                        progressDialog.dismiss();
                        if(makyajlar.size()>0) {



                            initRecycleView(makyajlar);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<MakyajModel> makyajList)
    {
        recyclerView =findViewById(R.id.rcvMakyaj);
        MakyajAdaptor makyajAdaptor =new MakyajAdaptor(makyajList, getApplicationContext(), new MakyajAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {

                MakyajModel tiklananMakyaj =makyajList.get(position);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.tiklama_adi) + tiklananMakyaj.getAdi(), Toast.LENGTH_SHORT).show();
                opennextActivity(tiklananMakyaj);

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(makyajAdaptor);
    }
    @Override
    public void onBackPressed() {
        AlertDialogUtil.AlertUtil(ListeActivity.this ,getResources().getString(R.string.app_unlem),getResources().getString(R.string.app_cikma),getResources().getString(R.string.app_evet),getResources().getString(R.string.app_hayir),getResources().getString(R.string.gosterilcekekranliste));
         }
    private void opennextActivity(MakyajModel tiklananMakyaj){
        Intent secondActivityIntent=new Intent(getApplicationContext(), MakyajDetayActivity.class);
        String tiklananMakyajString= ObjectUtil.makyajToJsonString(tiklananMakyaj);
        secondActivityIntent.putExtra(Constants.TIKLANAN_MAKYAJ_TASINANIN_BASLIGI,tiklananMakyajString);
        startActivity(secondActivityIntent);
    }

}