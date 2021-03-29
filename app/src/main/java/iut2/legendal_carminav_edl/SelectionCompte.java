package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import iut2.legendal_carminav_edl.bd.DatabaseClient;
import iut2.legendal_carminav_edl.bd.User;

public class SelectionCompte extends AppCompatActivity {

    private DatabaseClient mDb;
    private UserAdapter adapter;

    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_compte);

        mDb = DatabaseClient.getInstance(getApplicationContext());

        listUser = findViewById(R.id.listUser);

        adapter = new UserAdapter(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

    }

    //TODO : getUsers et onStart mais à voir si dans main avtivity on non
}