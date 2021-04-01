package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectionExerciceActivity extends AppCompatActivity {

    private HashMap<Button, Integer> nbNiveauMap = new HashMap<>();
    private List<Button> exerciceButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_exercice);

        Button buttonMath = findViewById(R.id.button_math);
        Button buttonCultureG = findViewById(R.id.button_gulture_g);
        exerciceButtons.add(buttonMath);
        exerciceButtons.add(buttonCultureG);

        nbNiveauMap.put(buttonMath, 3);
        nbNiveauMap.put(buttonCultureG, 1);

        for (Button button : exerciceButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SelectionExerciceActivity.this, ChoixNiveauActivity.class);
                    intent.putExtra(ChoixNiveauActivity.NB_NIVEAU_KEY, nbNiveauMap.get(button));
                    startActivity(intent);
                }
            });
        }


    }
}