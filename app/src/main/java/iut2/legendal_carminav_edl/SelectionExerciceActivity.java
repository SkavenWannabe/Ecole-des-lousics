package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.Matiere;
import iut2.legendal_carminav_edl.bd.User;
import iut2.legendal_carminav_edl.modele.VGlobal;

public class SelectionExerciceActivity extends AppCompatActivity {

    private DatabaseClient mDb;
    private MatiereAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_exercice);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        ListView matiereListView = findViewById(R.id.listview_matiere);

        User user = ((VGlobal) this.getApplication()).getUtilisateur();
        if (user != null) {
            setTitle(user.getNomComplet());
        } else {
            setTitle("Anonyme");
        }

        adapter = new MatiereAdapter(this, new ArrayList<Matiere>());

        matiereListView.setAdapter(adapter);

    }

    private void getMatieres() {
        class GetMatieres extends AsyncTask<Void, Void, List<Matiere>> {

            @Override
            protected List<Matiere> doInBackground(Void... voids) {
                List<Matiere> matiereList = mDb.getAppDatabase().matiereDao().getAll();

                return matiereList;
            }

            @Override
            protected void onPostExecute(List<Matiere> matiere) {
                super.onPostExecute(matiere);

                adapter.clear();
                adapter.addAll(matiere);

                adapter.notifyDataSetChanged();

            }
        }

        GetMatieres gm = new GetMatieres();
        gm.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getMatieres();
    }
}