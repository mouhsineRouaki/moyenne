package com.example.mysecondapp;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {
    private EditText ct1;
    private EditText ct2;
    private EditText ct3;
    private EditText ct4;
    private TextView moyenne;
    private TextView moyenne1;
    private Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ct1 = findViewById(R.id.ct1);
        ct2 = findViewById(R.id.ct2);
        ct3 = findViewById(R.id.ct3);
        ct4 = findViewById(R.id.ct4);
        moyenne = findViewById(R.id.info);


        Button button = findViewById(R.id.calcul);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cont1 = ct1.getText().toString();
                calculermoyene();
            }

            private void calculermoyene() {
                String cont1 = ct1.getText().toString();
                String cont2 = ct2.getText().toString();
                String cont3 = ct3.getText().toString();
                String cont4 = ct4.getText().toString();

                if (TextUtils.isEmpty(cont1) || TextUtils.isEmpty(cont2) || TextUtils.isEmpty(cont3) || TextUtils.isEmpty(cont4)) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les note de les controles", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    float ct1 = Float.parseFloat(cont1);
                    float ct2 = Float.parseFloat(cont2);
                    float ct3 = Float.parseFloat(cont3);
                    float ct4 = Float.parseFloat(cont4); // Convert height to meters

                    if (ct1 < 0 || ct1 > 20) {
                        Toast.makeText(getApplicationContext(), "entre la note DE CONTROLE1 entre 0 et 20", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (ct2 < 0 || ct2 > 20) {
                        Toast.makeText(getApplicationContext(), "entrey la note DE CONTROLE2 entre 0 et 20", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (ct3 < 0 || ct3 > 20) {
                        Toast.makeText(getApplicationContext(), "entrey la note DE CONTROLE3 entre 0 et 20", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (ct4 < 0 || ct4 > 20) {
                        Toast.makeText(getApplicationContext(), "entrey la note DE CONTROLE4 entre 0 et 20", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    float moy = (ct1 + ct2 + ct3 + ct4) / 4;
                    String resultatIMC = passagecontrole(moy);
                    moyenne.setText("Votre moyenne est : " + moy + "\n" + resultatIMC);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Veuillez entrer des valeurs numériques valides", Toast.LENGTH_SHORT).show();
                }
            }

            private String passagecontrole(float moy) {
                if (moy >= 16) {
                    return "excelente";
                }
                if (moy >= 14 || moy < 16) {
                    return "tres bien";
                }
                if (moy >= 10 || moy < 12) {
                    return "asez bien";
                }
                if (moy >= 0 || moy < 10) {
                    return "echec";
                }
                return"true";
            }
        });
    };
}