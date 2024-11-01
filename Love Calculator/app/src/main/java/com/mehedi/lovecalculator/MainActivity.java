package com.mehedi.lovecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast; // Import Toast for showing messages
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText maleName, femaleName;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleName = findViewById(R.id.editTextMale);
        femaleName = findViewById(R.id.editTextFemale);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String male = maleName.getText().toString().trim();
                String female = femaleName.getText().toString().trim();

                if (male.isEmpty() || female.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter Both Names", Toast.LENGTH_SHORT).show();
                } else {
                    String combinedNames = male + female;
                    int result = calculateLovePercentage(combinedNames);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("maleName", male);
                    intent.putExtra("femaleName", female);
                    intent.putExtra("lovePercentage", result);
                    startActivity(intent);
                }
            }
        });
    }

    public int calculateLovePercentage(String names) {
        int hashCode = names.toLowerCase().hashCode();
        Random random = new Random(hashCode);
        return random.nextInt(100) + 1;
    }
}
