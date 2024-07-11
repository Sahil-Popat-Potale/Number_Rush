package com.sahilpopat.number_rush;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LevelsActivity extends AppCompatActivity {
    public static final String EXTRA_LEVEL = "extra_level";
    public static final int DELAY_MILLIS = 800; // 0.8 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_levels);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int level = getIntent().getIntExtra(EXTRA_LEVEL, 1);
        delayFragment(level);
    }

    public void delayFragment(int level){
        new Handler().postDelayed(() -> loadLevelFragment(level), DELAY_MILLIS);
    }

    public void loadLevelFragment(int level) {
        Fragment fragment = null;

        switch (level) {
            case 1:
                fragment = new Level1Fragment();
                break;
            case 2:
                fragment = new Level2Fragment();
                break;
            case 3:
                fragment = new Level3Fragment();
                break;
            case 4:
                fragment = new Level4Fragment();
                break;
            case 5:
                fragment = new Level5Fragment();
                break;
            default:
                Toast.makeText(this, "Invalid level", Toast.LENGTH_SHORT).show();
                return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.enter_bottom, R.anim.exit_top,
                R.anim.enter_right, R.anim.exit_left);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}