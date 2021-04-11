package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.Question;
import iut2.legendal_carminav_edl.modele.Exercice;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class ChoixNiveauActivity extends AppCompatActivity {

    public static final String NB_NIVEAU_KEY = "nb_niveau_key";

    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_niveau);

        Matiere matiere = ((VGlobal) this.getApplication()).getMatiere();
        setTitle(matiere.getNom());
        int nbNiveaux = matiere.getNbNiveaux();

        mDb = DatabaseClient.getInstance(getApplicationContext());

        Button btnTableMul = findViewById(R.id.niveau_btn_tmul);
        LinearLayout mainLinear = findViewById(R.id.choix_niveau_linear);

        for (int i = 1; i < nbNiveaux + 1; ++i) {
            LinearLayout linearTemplate = (LinearLayout) getLayoutInflater().inflate(R.layout.template_niveau, null);
            linearTemplate.setHorizontalGravity(17);

            Button button = linearTemplate.findViewById(R.id.template_button);
            button.setText("Exercice " + i);

            int finalI = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((VGlobal) getApplication()).setNiveau(finalI);
                    sendExercice(matiere, finalI);
                }
            });

            mainLinear.addView(linearTemplate);
        }

        if (matiere.getNom().equals("Mathématiques")) {
            btnTableMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChoixNiveauActivity.this, TableMultiplicationActivity.class);
                    startActivity(intent);
                }
            });

            btnTableMul.setVisibility(View.VISIBLE);
        }
    }

    private void sendExercice(Matiere matiere, int nbNiveau) {
        class GetExercice extends AsyncTask<Void, Void, List<Question>> {

            @Override
            protected List<Question> doInBackground(Void... voids) {
                List<Question> questionList = mDb.getAppDatabase().questionDao().getWithMatiereAndNiveau(matiere.toString(), nbNiveau);

                return questionList;
            }

            @Override
            protected void onPostExecute(List<Question> questionList) {
                super.onPostExecute(questionList);

                Exercice exercice = new Exercice(matiere, (ArrayList<Question>) questionList);
                Intent intent = new Intent(ChoixNiveauActivity.this, ExerciceActivity.class);
                intent.putExtra(ExerciceActivity.EXERCICE_KEY, exercice);
                startActivity(intent);

            }
        }

        GetExercice ge = new GetExercice();
        ge.execute();
    }


}