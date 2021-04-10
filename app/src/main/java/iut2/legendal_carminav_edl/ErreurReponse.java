package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErreurReponse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur_reponse);

        Button btn_exo = (Button) findViewById(R.id.btn_exo);
        Button btn_level = (Button) findViewById(R.id.btn_level);

        btn_exo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : adapter ce boutton lorsque l'activité sera dévelloper
                Intent intent = new Intent(ErreurReponse.this, ChoixNiveauActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btn_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ErreurReponse.this, SelectionExerciceActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}