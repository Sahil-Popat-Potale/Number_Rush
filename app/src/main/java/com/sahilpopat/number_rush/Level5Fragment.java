package com.sahilpopat.number_rush;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Level5Fragment extends Fragment {
    TextView instructionText;
    GridLayout gridLayout;
    private int currentNumber = 1;

    public Level5Fragment() { // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_level5, container, false);
        instructionText = view.findViewById(R.id.instructionText);
        gridLayout = view.findViewById(R.id.gridLayout);

        setButtonListeners(view);

        return view;
    }

    private void setButtonListeners(View view) {
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
            Button button = view.findViewById(resID);
            button.setOnClickListener(v -> onNumberClick(Integer.parseInt(button.getText().toString()), button));
        }
    }

    private void onNumberClick(int number, Button button) {
        if (number == currentNumber) {
            button.setEnabled(false);
            currentNumber++;
            if (currentNumber > 10) {
                Toast.makeText(getActivity(), "You Win!", Toast.LENGTH_SHORT).show();
                resetGame();
                //take user to next level
                //((LevelsActivity) requireActivity()).loadLevelFragment(6);
            }
        } else {
            Toast.makeText(getActivity(), "Wrong number! You Lose!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void resetGame() {
        currentNumber = 1;
        for (int i = 1; i <= 10; i++) {
            String buttonID = "btn" + i;
            int resID = getResources().getIdentifier(buttonID, "id", requireActivity().getPackageName());
            Button button = requireView().findViewById(resID);
            button.setEnabled(true);
        }
    }
}