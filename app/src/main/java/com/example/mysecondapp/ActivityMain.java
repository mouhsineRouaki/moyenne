package com.example.mysecondapp;

import android.annotation.SuppressLint;
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
                calculerMoyenne();
            }
            private void calculerMoyenne() {
                String cont1 = ct1.getText().toString();
                String cont2 = ct2.getText().toString();
                String cont3 = ct3.getText().toString();
                String cont4 = ct4.getText().toString();
                if (TextUtils.isEmpty(cont1) || TextUtils.isEmpty(cont2) || TextUtils.isEmpty(cont3) || TextUtils.isEmpty(cont4)) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir toutes les notes de contrôle", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    float note1 = Float.parseFloat(cont1);
                    float note2 = Float.parseFloat(cont2);
                    float note3 = Float.parseFloat(cont3);
                    float note4 = Float.parseFloat(cont4);

                    // Validation des notes
                    if (note1 < 0 || note1 > 20 || note2 < 0 || note2 > 20 || note3 < 0 || note3 > 20 || note4 < 0 || note4 > 20) {
                        Toast.makeText(getApplicationContext(), "Toutes les notes doivent être entre 0 et 20", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    
                    float moy = (note1 + note2 + note3 + note4) / 4;
                    String resultat = passageControle(moy);
                    moyenne.setText("Votre moyenne est : " +moy + "\n" + resultat);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Veuillez entrer des valeurs numériques valides", Toast.LENGTH_SHORT).show();
                }
            }

            private String passageControle(float moy) {
                if (moy >= 16) {
                    return "Excellente";
                } else if (moy >= 14 && moy < 16) {
                    return "Très bien";
                } else if (moy >= 12 && moy < 14) {
                    return "Bien";
                } else if (moy >= 10 && moy < 12) {
                    return "Assez bien";
                } else {
                    return "Échec";
                }
            }
        });
    }
}
