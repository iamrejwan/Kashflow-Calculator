package com.example.bkash.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bkash.R;
import com.google.android.material.textfield.TextInputEditText;

public class BaseFragment extends Fragment {

    private Double BKASH_CHARGE = 1.75;
    private Double NAGAD_CHARGE = 1.149;
    private SharedPreferences sharedPref;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextInputEditText amountInput = view.findViewById(R.id.text_input);
        Button calculateBtn = view.findViewById(R.id.calculate);

        sharedPref = getActivity().getSharedPreferences("", Context.MODE_PRIVATE);

       calculateBtn.setOnClickListener(view1 -> {
           if (sharedPref.getString("TAG", "").equals("bkash")){

               title.setText(getString(R.string.bkash_cashout_calculator));
               description.setText(getString(R.string.cashing_out_from_app_bkash));
               int charges = calculateCharges(Integer.parseInt(amountInput.getText().toString()), BKASH_CHARGE);

           }else if (sharedPref.getString("TAG", "").equals("nagad")){
               title.setText(getString(R.string.nagad_cashout_calculator));
               description.setText(getString(R.string.cashing_out_from_app_nagad));
               int charges = calculateCharges(Integer.parseInt(amountInput.getText().toString()), NAGAD_CHARGE);

           }else{
               title.setText(getString(R.string.bkash_cashout_calculator));
               description.setText(getString(R.string.cashing_out_from_app_bkash));
               int charges = calculateCharges(Integer.parseInt(amountInput.getText().toString()), BKASH_CHARGE);
           }


       });



    }

    private int calculateCharges(int amount, Double changes){

        return (int) Math.round(changes * amount/100.0);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bkash, container, false);


    }
}
