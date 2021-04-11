package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ErreurReponse extends AppCompatActivity {

    public final static String NB_ERREURS_KEY = "nb_erreurs_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_reponse);

        TextView nombreErreurText = findViewById(R.id.nombre_erreur);
        Button btn_exo = (Button) findViewById(R.id.erreur_choisir_exo);
        Button btn_corriger = (Button) findViewById(R.id.erreur_btn_corriger);
        int nbErreurs = getIntent().getIntExtra(NB_ERREURS_KEY, 0);

        nombreErreurText.setText(String.valueOf(nbErreurs));

        btn_exo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : adapter ce boutton lorsque l'activité sera dévelloper
                Intent intent = new Intent(ErreurReponse.this, ChoixNiveauActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_corriger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ErreurReponse.this, SelectionExerciceActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                finish();
            }
        });
    }
}