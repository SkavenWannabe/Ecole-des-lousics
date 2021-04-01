package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ChoixNiveauActivity extends AppCompatActivity {

    public static final String NB_NIVEAU_KEY = "nb_niveau_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_niveau);

        LinearLayout mainLinear = findViewById(R.id.choix_niveau_linear);

        int nbNiveaux = getIntent().getIntExtra(NB_NIVEAU_KEY, 0);

        for (int i = 1; i < nbNiveaux + 1; ++i) {
            LinearLayout linearTemplate = (LinearLayout) getLayoutInflater().inflate(R.layout.template_niveau, null);
            linearTemplate.setHorizontalGravity(17);

            Button button = linearTemplate.findViewById(R.id.template_button);
            button.setText("Exercice " + i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            mainLinear.addView(linearTemplate);
        }
    }
}