package com.example.bkash.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.bkash.R;

public class ToastMsg {
    Context context;
    LayoutInflater inflater;
    public ToastMsg(Context context) {
        this.context=context;
        inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }
    public void toastIconError(String s) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        //inflate view
        @SuppressLint("InflateParams") View custom_view = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) custom_view.findViewById(R.id.message)).setText(s);
        ((ImageView) custom_view.findViewById(R.id.icon)).setImageResource(R.drawable.ic_close);
        ((CardView) custom_view.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.red_600));
        toast.setView(custom_view);
        toast.show();
    }

    public void toastIconSuccess(String s) {
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        //inflate view
        @SuppressLint("InflateParams") View custom_view = inflater.inflate(R.layout.toast_icon_text, null);
        ((TextView) custom_view.findViewById(R.id.message)).setText(s);
        ((ImageView) custom_view.findViewById(R.id.icon)).setImageResource(R.drawable.ic_done);
        ((CardView) custom_view.findViewById(R.id.parent_view)).setCardBackgroundColor(context.getResources().getColor(R.color.green_500));

        toast.setView(custom_view);
        toast.show();
    }
}
