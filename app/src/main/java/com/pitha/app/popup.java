package com.pitha.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class popup extends Activity{
    TextView textView;
    String cartItems;
    String cartShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            cartItems = bundle.getString("cart_item_lists");

        }

        textView = findViewById(R.id.textView);
        setContentView(R.layout.popuplayout);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8),(int)(height*.6));



        String cartt[] = cartItems.split("}");

        for(int i =0; i<cartt.length; i++){
            cartShow = cartShow+cartt[i];
        }

        textView.setText(cartShow);

    }
}
