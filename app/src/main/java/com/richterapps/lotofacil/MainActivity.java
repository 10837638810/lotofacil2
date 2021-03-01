package com.richterapps.lotofacil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_STORAGE = 1;
    static TextView txt;

    private File diretorio;
    private String nomeDiretorio="LOTOFACIL";
    private String diretorioApp;
    private String arquivo = "lotofacil.txt";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyStoragePermissions(this);

        diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";

        diretorio = new File(diretorioApp);
        diretorio.mkdirs();
        File fileExt = new File(diretorioApp, arquivo);
        fileExt.getParentFile().mkdirs();


        String combinacoes = "String";

        String pesquisa = "";
        int idCombinacaoLotofacil = 0;
        for (int p1 = 1; p1 <= 11; p1++) {
            for (int p2 = p1 + 1; p2 <= 12; p2++) {
                for (int p3 = p2 + 1; p3 <= 13; p3++) {
                    for (int p4 = p3 + 1; p4 <= 14; p4++) {
                        for (int p5 = p4 + 1; p5 <= 15; p5++) {
                            for (int p6 = p5 + 1; p6 <= 16; p6++) {
                                for (int p7 = p6 + 1; p7 <= 17; p7++) {
                                    for (int p8 = p7 + 1; p8 <= 18; p8++) {
                                        for (int p9 = p8 + 1; p9 <= 19; p9++) {
                                            for (int p10 = p9 + 1; p10 <= 20; p10++) {
                                                for (int p11 = p10 + 1; p11 <= 21; p11++) {
                                                    for (int p12 = p11 + 1; p12 <= 22; p12++) {
                                                        for (int p13 = p12 + 1; p13 <= 23; p13++) {
                                                            for (int p14 = p13 + 1; p14 <= 24; p14++) {
                                                                for (int p15 = p14 + 1; p15 <= 25; p15++) {

                                                                    idCombinacaoLotofacil++;

                                                                    pesquisa = String.format("%02d,", p1) +
                                                                            String.format("%02d,", p2) +
                                                                            String.format("%02d,", p3) +
                                                                            String.format("%02d,", p4) +
                                                                            String.format("%02d,", p5) +
                                                                            String.format("%02d,", p6) +
                                                                            String.format("%02d,", p7) +
                                                                            String.format("%02d,", p8) +
                                                                            String.format("%02d,", p9) +
                                                                            p10 + "," +
                                                                            p11 + "," +
                                                                            p12 + "," +
                                                                            p13 + "," +
                                                                            p14 + "," +
                                                                            p15;

                                                                    combinacoes = "|"+idCombinacaoLotofacil+"|>"+pesquisa+"\n";
                                                                    //String[] texto={};
                                                                    //texto[0]= combinacoes;
                                                                    System.out.println(combinacoes);


                                                                        try {
                                                                            FileOutputStream fosExt = new FileOutputStream(fileExt);
                                                                            fosExt.write(combinacoes.getBytes());
                                                                            //fosExt.append(combinacoes);
                                                                            fosExt.flush();
                                                                            fosExt.close();
                                                                        } catch (Exception e) {
                                                                            Log.e("ERRO", e.getMessage());
                                                                        }
/*
                                                                    try {
                                                                        FileWriter gravacao = new FileWriter(fileExt);
                                                                        BufferedWriter bf = new BufferedWriter(gravacao);
                                                                        for (int i = 0; i < texto.length; i++){
                                                                            bf.write(texto[i]);
                                                                            bf.newLine();
                                                                            System.out.println(texto);

                                                                        }
                                                                        bf.append(combinacoes);
                                                                        bf.flush();
                                                                        bf.close();
                                                                    } catch ( IOException e ) { e.printStackTrace(); }*/

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }




        System.out.println("FIM");

    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}