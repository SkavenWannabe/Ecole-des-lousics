package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.User;

public class CreationCompte extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        Button btn_retour = findViewById(R.id.btn_retour);
        Button btn_insc = findViewById(R.id.btn_insc);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationCompte.this, MainActivity.class);
            }
        });

        btn_insc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                Intent intent = new Intent(CreationCompte.this, SelectionExerciceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveUser() {
        EditText inp_nom = findViewById(R.id.inp_nom);
        EditText inp_prenom = findViewById(R.id.inp_prenom);

        final String nom = inp_nom.getText().toString();
        final String prenom = inp_prenom.getText().toString();

        if(nom.isEmpty() || prenom.isEmpty()) {
            return;
        }

        class SaveUser extends AsyncTask<Void, Void, User> {
            @Override
            protected User doInBackground(Void... voids) {
                User user = new User();
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setCulture_level(1);
                user.setMath_add_level(1);
                user.setMath_div_level(1);
                user.setMath_mul_level(1);
                user.setMath_sub_level(1);

                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().userDao().insert(user);

                return user;
            }

            @Override
            protected  void onPostExecute(User user) {
                super.onPostExecute(user);

                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveUser su = new SaveUser();
        su.execute();
    }
}