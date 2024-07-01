package com.sahilpopat.number_rush;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView instructionText;
    GridLayout gridLayout;
    private int currentNumber = 1;
    //TODO: not working
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        instructionText = findViewById(R.id.instructionText);
        gridLayout = findViewById(R.id.gridLayout);

        setButtonListeners();
    }

    private void setButtonListeners() {
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button button = findViewById(resID);
            button.setOnClickListener(v -> onNumberClick(Integer.parseInt(button.getText().toString()), button));
        }
    }

    private void onNumberClick(int number, Button button) {
        if (number == currentNumber) {
            button.setEnabled(false);
            currentNumber++;
            if (currentNumber > 10) {
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show();
                resetGame();
            }
        } else {
            Toast.makeText(this, "Wrong number! You Lose!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void resetGame() {
        currentNumber = 1;
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button button = findViewById(resID);
            button.setEnabled(true);
        }
    }
}