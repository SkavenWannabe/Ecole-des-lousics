package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import iut2.legendal_carminav_edl.modele.Multiplication;
import iut2.legendal_carminav_edl.modele.TableMultiplication;

public class TableMultiplicationActivity extends AppCompatActivity {

    private TableMultiplicationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        //Récupération des View
        ListView tableMulListView = findViewById(R.id.tmul_listview);
        Button btnValider = findViewById(R.id.btn_valider);

        //Instanciation de la table de multiplication
        TableMultiplication tableMultiplication = new TableMultiplication(10);
        setTitle("Table de " + tableMultiplication.getNumero());

        //Adapter & cie
        adapter = new TableMultiplicationAdapter(this, tableMultiplication.getMultiplications());
        tableMulListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nbErreurs = 0;

                for (int i = 0; i < tableMultiplication.getNbMultiplications(); i++) {
                    Multiplication multiplication = adapter.getItem(i);
                    if (multiplication.getResultat() != multiplication.getReponse()) {
                        nbErreurs++;
                    }
                }

                if (nbErreurs == 0) {
                    Intent intent = new Intent(TableMultiplicationActivity.this, FelicitationReponse.class);
                    finish();
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(TableMultiplicationActivity.this, ErreurReponse.class);
                    intent.putExtra(ErreurReponse.NB_ERREURS_KEY, nbErreurs);
                    startActivity(intent);
                }
            }
        });
    }
}