package iut2.legendal_carminav_edl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent tablesMultiplication = new Intent(this, TableMultiplicationActivity.class);

        Button buttonTable = findViewById(R.id.button_table_multiplication);

        buttonTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tablesMultiplication);
            }
        });
    }
}