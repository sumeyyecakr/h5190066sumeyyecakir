package com.h5190066.sumeyye_cakir_final.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;

import com.h5190066.sumeyye_cakir_final.R;

public class AlertDialogUtil {
    public static void AlertUtil(
    Context context, String baslikdialog, String icerik, String dogrudialog, String yanlisdialog ,String yazilcakekran)
    {
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(baslikdialog);
        builder.setMessage(icerik);
        builder.setPositiveButton(dogrudialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(yazilcakekran.toString() == context.getResources().getString(R.string.gosterilcekekranmain)){
                    context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                }
                else {
                    ((Activity)context).onBackPressed();
                    ((Activity)context).finish();
                }

            }
        });

        builder.setNegativeButton(yanlisdialog, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface window, int i) {
                if(yazilcakekran.toString() == context.getResources().getString(R.string.gosterilcekekranmain)){
                    ((Activity)context).finish();
                }
                else{
                    window.dismiss();
                }

            }
        });
        builder.show();
    }

}
