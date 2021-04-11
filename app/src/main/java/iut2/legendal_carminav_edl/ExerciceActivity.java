package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.Question;
import iut2.legendal_carminav_edl.modele.Exercice;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class ExerciceActivity extends AppCompatActivity {

    public final static String EXERCICE_KEY = "exercice_key";

    private Exercice exercice;
    private DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        this.exercice = getIntent().getParcelableExtra(EXERCICE_KEY);

        updateExercice();

        Button boutonPrecedent = findViewById(R.id.exercice_precedent);
        Button boutonSuivant = findViewById(R.id.exercice_suivant);
        EditText reponseUser = findViewById(R.id.exercice_reponse);

        Matiere matiere = ((VGlobal) getApplication()).getMatiere();
        reponseUser.setInputType(matiere.getInputType());

        boutonPrecedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText reponseUser = findViewById(R.id.exercice_reponse);
                exercice.setReponse(reponseUser.getText().toString());
                reponseUser.setText("");

                if (exercice.getNumeroQuestionActive() == exercice.getNbQuestions()) {
                    boutonSuivant.setText("Suivant");
                    boutonSuivant.setTextColor(0xFF000000);
                }

                exercice.questionPrecedente();
                updateExercice();
            }
        });

        boutonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText reponseUser = findViewById(R.id.exercice_reponse);
                exercice.setReponse(reponseUser.getText().toString());
                reponseUser.setText("");

                if (exercice.getNumeroQuestionActive() == exercice.getNbQuestions() - 1) {
                    boutonSuivant.setText("Terminer");
                    boutonSuivant.setTextColor(0xFFF44336);
                    exercice.questionSuivante();
                } else if (exercice.getNumeroQuestionActive() == exercice.getNbQuestions()) {
                    //TODO : Terminer exercice
                    int nbErreurs = calculNbErreurs();
                    if (nbErreurs != 0) {
                        Intent intent = new Intent(ExerciceActivity.this, ErreurReponse.class);
                        intent.putExtra(ErreurReponse.NB_ERREURS_KEY, nbErreurs);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(ExerciceActivity.this, FelicitationReponse.class);
                        startActivity(intent);
                    }
                } else {
                    exercice.questionSuivante();
                }

                updateExercice();
            }
        });
    }

    private void updateExercice() {
        TextView numQuestionActiveText = findViewById(R.id.exercice_num_question_active);
        TextView nbQuestions = findViewById(R.id.exercice_num_question);

        TextView enonce = findViewById(R.id.exercice_question);
        EditText reponseText = findViewById(R.id.exercice_reponse);

        int numQuestionActive = exercice.getNumeroQuestionActive();

        numQuestionActiveText.setText(String.valueOf(numQuestionActive));
        nbQuestions.setText(String.valueOf(exercice.getNbQuestions()));

        enonce.setText(exercice.getQuestion(numQuestionActive).getEnonce());
        String reponseUser = exercice.getQuestion(numQuestionActive).getResponseUser();
        System.out.println(reponseUser);
        if (reponseUser != null) {
            reponseText.setText(reponseUser);
        }


    }

    private int calculNbErreurs() {
        int nbErreurs = 0;
        for (Question q : exercice.getQuestionList()) {
            if (!q.getResponseUser().equalsIgnoreCase(q.getBonneReponse())) {
                nbErreurs++;
            }
        }

        return nbErreurs;
    }

}