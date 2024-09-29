package com.sahilpopat.number_rush;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView lv1, lv2 , lv3, lv4, lv5, lv6, lv7 , lv8, lv9, lv10;

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

        lv1 = findViewById(R.id.lv1);
        lv2 = findViewById(R.id.lv2);
        lv3 = findViewById(R.id.lv3);
        lv4 = findViewById(R.id.lv4);
        lv5 = findViewById(R.id.lv5);
        lv6 = findViewById(R.id.lv6);
        lv7 = findViewById(R.id.lv7);
        lv8 = findViewById(R.id.lv8);
        lv9 = findViewById(R.id.lv9);
        lv10 = findViewById(R.id.lv10);

        lv1.setOnClickListener(v -> startLevelActivity(1));
        lv2.setOnClickListener(v -> startLevelActivity(2));
        lv3.setOnClickListener(v -> startLevelActivity(3));
        lv4.setOnClickListener(v -> startLevelActivity(4));
        lv5.setOnClickListener(v -> startLevelActivity(5));
        lv6.setOnClickListener(v -> startLevelActivity(6));
        lv7.setOnClickListener(v -> startLevelActivity(7));
        lv8.setOnClickListener(v -> startLevelActivity(8));
        lv9.setOnClickListener(v -> startLevelActivity(9));
        lv9.setOnClickListener(v -> startLevelActivity(10));
    }

    private void startLevelActivity(int level) {
        Intent intent = new Intent(MainActivity.this, LevelsActivity.class);
        intent.putExtra(LevelsActivity.EXTRA_LEVEL, level);
        startActivity(intent);
    }
}