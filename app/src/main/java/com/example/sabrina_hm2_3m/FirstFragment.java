package com.example.sabrina_hm2_3m;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private Button btnPlus1, btnMinus1, btnNext;
    private TextView tvText;
    private int num;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private void initView() {
        tvText = requireActivity().findViewById(R.id.tv_text);
        btnPlus1 = requireActivity().findViewById(R.id.btn_plus1);
        btnMinus1 = requireActivity().findViewById(R.id.btn_minus1);
        btnNext = requireActivity().findViewById(R.id.btn_next);
    }


    private void initListener() {
        btnPlus1.setOnClickListener(v -> {
            num++;
           tvText.setText(String.valueOf(num));
        });

        btnMinus1.setOnClickListener(v -> {
            num--;
            tvText.setText(String.valueOf(num));
        });

        btnNext.setOnClickListener(v -> {
            goToSecondFragment();
        });
    }

    private void goToSecondFragment() {

        Bundle bundle = new Bundle();
        bundle.putString("text", tvText.getText().toString());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_second_container, secondFragment).addToBackStack(null).commit();
    }
}