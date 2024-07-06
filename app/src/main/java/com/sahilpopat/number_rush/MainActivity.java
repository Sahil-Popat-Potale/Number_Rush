package com.sahilpopat.number_rush;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView lv1, lv2 , lv3, lv4, lv5;
    CardView level1, level2, level3, level4, level5;

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

        level1 = findViewById(R.id.level1);
        lv1 = findViewById(R.id.lv1);
        level2 = findViewById(R.id.level2);
        lv2 = findViewById(R.id.lv2);
        level3 = findViewById(R.id.level3);
        lv3 = findViewById(R.id.lv3);
        level4 = findViewById(R.id.level4);
        lv4 = findViewById(R.id.lv4);
        level5 = findViewById(R.id.level5);
        lv5 = findViewById(R.id.lv5);

        level1.setOnClickListener(v -> startLevelActivity(1));
        lv1.setOnClickListener(v -> startLevelActivity(1));
        level2.setOnClickListener(v -> startLevelActivity(2));
        lv2.setOnClickListener(v -> startLevelActivity(2));
        level3.setOnClickListener(v -> startLevelActivity(3));
        lv3.setOnClickListener(v -> startLevelActivity(3));
        level4.setOnClickListener(v -> startLevelActivity(4));
        lv4.setOnClickListener(v -> startLevelActivity(4));
    }

    private void startLevelActivity(int level) {
        Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
        intent.putExtra(LevelsActivity.EXTRA_LEVEL, level);
        startActivity(intent);
    }
}