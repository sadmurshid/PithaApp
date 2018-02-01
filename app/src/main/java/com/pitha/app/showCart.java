package com.pitha.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showCart extends AppCompatActivity {

    TextView textView;
    String cartItems;
    String cartShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            cartItems = bundle.getString("cart_items");
        }

        textView = findViewById(R.id.text_Views);


        String cartt[] = cartItems.split("}");

        for(int i =0; i<cartt.length; i++){
            cartShow = cartShow+cartt[i];
        }

        textView.setText(cartShow);
    }
}
