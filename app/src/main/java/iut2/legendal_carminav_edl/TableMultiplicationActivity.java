package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import iut2.legendal_carminav_edl.modele.Multiplication;
import iut2.legendal_carminav_edl.modele.TableMultiplication;

public class TableMultiplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        LinearLayout linear = findViewById(R.id.table_linear);

        TableMultiplication tableMultiplication = new TableMultiplication(8, 10);
        for (Multiplication multiplication : tableMultiplication.getMultiplications()) {
            LinearLayout linearTemplate = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            linearTemplate.setHorizontalGravity(17);

            TextView calcul = linearTemplate.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOperande1() + "*" + multiplication.getOperande2() + " = ");


            linear.addView(linearTemplate);
        }

        Button btnValider = findViewById(R.id.btn_valider);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Multiplication multiplication : tableMultiplication.getMultiplications()) {
                    LinearLayout linearTemplate = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

                    EditText resultat = linearTemplate.findViewById(R.id.template_resultat);
                    //TODO : Calculer le nombre d'erreurs
                }
            }
        });
    }
}