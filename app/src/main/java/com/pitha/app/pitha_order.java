package com.pitha.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class pitha_order extends AppCompatActivity implements View.OnClickListener{
    ImageView pithaImage;
    TextView pitha_name_text_view;
    EditText pitha_amount;
    TextView tk_textView;
    Button add_to_cart_button;
    Button delte_cart_button;
    Button show_cart_button;
    Button order_button;
    Button inputButton;

    String showAmount;
    String pname;
    String cart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitha_order);

        pithaImage = findViewById(R.id.pitha_image);
        pitha_name_text_view = findViewById(R.id.pitha_name_view);
        pitha_amount = findViewById(R.id.editAmount);
        tk_textView = findViewById(R.id.tk_textViews);
        add_to_cart_button = findViewById(R.id.add_cart_Button);
        delte_cart_button = findViewById(R.id.delete_cart_Button);
        show_cart_button = findViewById(R.id.show_cart_Button);
        order_button = findViewById(R.id.order_Button);
        inputButton = findViewById(R.id.input_amount);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            pitha_name_text_view.setText(bundle.getString("pitha_name"));
        }

        pname = pitha_name_text_view.getText().toString();
        showImage(pname);


        add_to_cart_button.setOnClickListener(this);
        delte_cart_button.setOnClickListener(this);
        show_cart_button.setOnClickListener(this);
        order_button.setOnClickListener(this);
        inputButton.setOnClickListener(this);



    }

    public void showImage(String name){

        if (name.equalsIgnoreCase("vapa puli pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.vapa_puli_pitha));
        }
        else if (name.equalsIgnoreCase("pakkon pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.pakon_pitha));
        }
        else if (name.equalsIgnoreCase("vapa pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.vapa_pitha));
        }
        else if (name.equalsIgnoreCase("patishapta")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.patishapta));
        }
        else if (name.equalsIgnoreCase("Chitoi Pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.chitoi_pitha));
        }
        else if (name.equalsIgnoreCase("khir puli")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.khir_puli));
        }
        else if (name.equalsIgnoreCase("shamuk pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.samuk_pitha));
        }
        else if (name.equalsIgnoreCase("chui pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.chui_pitha));
        }
        else if (name.equalsIgnoreCase("pata pitha")){
            pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.patapitha));
        }


    }



    public String calculateAmount(String p, String quantity){

        int q = Integer.parseInt(quantity);
        int result = 0;

        if (p.equalsIgnoreCase("vapa puli pitha")){
            result = q*10;
        }
        else if (p.equalsIgnoreCase("pakkon pitha")){
            result = q*20;

        }
        else if (p.equalsIgnoreCase("vapa pitha")){
            result = q*10;

        }
        else if (p.equalsIgnoreCase("patishapta")){
            result = q*30;

        }
        else if (p.equalsIgnoreCase("Chitoi Pitha")){
            result = q*10;

        }
        else if (p.equalsIgnoreCase("khir puli")){
            result = q*40;

        }
        else if (p.equalsIgnoreCase("shamuk pitha")){
            result = q*10;

        }
        else if (p.equalsIgnoreCase("chui pitha")){
            result = q*10;

        }
        else if (p.equalsIgnoreCase("pata pitha")){
            result = q*40;

        }

        return "total for "+p+"is tk: "+result;
    }

    @Override
    public void onClick(View view) {
        if(view == add_to_cart_button){
            addToCart();
        }

        if(view == show_cart_button){
            showCart(cart);
        }

        if(view == delte_cart_button){

        }

        if(view == order_button){

        }

        if(view == inputButton ){

            showAmount = calculateAmount(pitha_name_text_view.getText().toString().trim(),pitha_amount.getText().toString());
            tk_textView.setText(showAmount);
        }
    }


    public void addToCart(){
        String name = pitha_name_text_view.getText().toString().trim();
        String amount = pitha_amount.getText().toString();
        String price = calculateAmount(name,amount);
        cart = cart+"pitha name: "+name+","+"Amount: "+amount+","+"Price: "+price+"}"+"\n";
    }

    public void showCart(String carts){
        Intent intent = new Intent(getApplicationContext(),popup.class);
        intent.putExtra("cart_item_lists", carts);
        startActivity(intent);
    }
}
