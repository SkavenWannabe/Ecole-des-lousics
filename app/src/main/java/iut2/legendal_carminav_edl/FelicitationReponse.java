package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.Question;
import iut2.legendal_carminav_edl.modele.Exercice;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class FelicitationReponse extends AppCompatActivity {

    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitation_reponse);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        Button btnAutreExo = (Button) findViewById(R.id.win_autre_exo);
        Button btnNiveauSuivant = (Button) findViewById(R.id.win_niveau_suivant);

        btnAutreExo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : adapter ce boutton lorsque l'activité sera dévelloper
                Intent intent = new Intent(FelicitationReponse.this, ChoixNiveauActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnNiveauSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matiere matiere = ((VGlobal) FelicitationReponse.this.getApplication()).getMatiere();
                int nbNiveau = ((VGlobal) FelicitationReponse.this.getApplication()).getNiveau();
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + nbNiveau);
                if (nbNiveau == matiere.getNbNiveaux()) {
                    Intent intent = new Intent(FelicitationReponse.this, SelectionExerciceActivity.class);
                    Toast.makeText(FelicitationReponse.this, "Vous avez terminé tous les niveaux !", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(intent);
                } else {
                    ((VGlobal) FelicitationReponse.this.getApplication()).setNiveau(nbNiveau + 1);
                    sendExercice(matiere, nbNiveau + 1);
                }
            }
        });
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
                Intent intent = new Intent(FelicitationReponse.this, ExerciceActivity.class);
                intent.putExtra(ExerciceActivity.EXERCICE_KEY, exercice);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        }

        GetExercice ge = new GetExercice();
        ge.execute();
    }
}