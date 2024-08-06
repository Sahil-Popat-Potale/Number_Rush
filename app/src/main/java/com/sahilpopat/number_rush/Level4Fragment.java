package com.sahilpopat.number_rush;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Level4Fragment extends Fragment {
    TextView instructionText;
    GridLayout gridLayout;
    private int currentNumber = 1;
    // Using a map to store original button text
    private final Map<Integer, String> originalBtnTxt = new HashMap<>();

    public Level4Fragment() { // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_level4, container, false);

        instructionText = view.findViewById(R.id.instructionText);
        gridLayout = view.findViewById(R.id.gridLayout);

        storeBtnTxt(view);
        setButtonListeners(view);
        return view;
    }

    private void storeBtnTxt(View view) { // Store original button text
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
            Button button = view.findViewById(resID);
            originalBtnTxt.put(resID, button.getText().toString());
        }
    }

    private void setButtonListeners(View view) {
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
            Button button = view.findViewById(resID);
            button.setOnClickListener(v -> {
                onNumberClick(Integer.parseInt(button.getText().toString()), button);
                animateButton(button);
            });
        }
    }

    private void onNumberClick(int number, Button button) {
        if (number == currentNumber) {
            button.setEnabled(false);
            button.setText("");
            currentNumber++;
            if (currentNumber > 10) {
                Toast.makeText(getActivity(), "You Win!", Toast.LENGTH_SHORT).show();
                resetGame();
                //take user to next level
                ((LevelsActivity) requireActivity()).delayFragment(5);
            }
        } else {
            Toast.makeText(getActivity(), "Wrong number! You Lose!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void animateButton(Button button) { // Animation here
        Animation animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.btn_pop);
        button.startAnimation(animation);
    }

    private void resetGame() {
        currentNumber = 1;
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
            Button button = requireView().findViewById(resID);
            button.setEnabled(true);
            button.setText(originalBtnTxt.get(resID)); // Reset button text
        }
    }
}