package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreationCompte extends AppCompatActivity {

    private Button btn_retour;
    private Button btn_insc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        btn_retour = findViewById(R.id.btn_retour);
        btn_insc = findViewById(R.id.btn_insc);

        btn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreationCompte.this, MainActivity.class);
            }
        });

    }
}