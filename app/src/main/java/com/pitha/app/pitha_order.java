package com.pitha.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class pitha_order extends AppCompatActivity {

    private ImageView pithaImage;
    private TextView pitha_name_text_view;
    private EditText pitha_amount;
    private TextView tk_textView;
    private Button add_to_cart_button;
    private Button delte_cart_button;
    private Button show_cart_button;
    private Button order_button;

    private String showAmount;
    private String pname;

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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){

            pitha_name_text_view.setText(bundle.getString("pitha name"));

            if (pitha_name_text_view.getText().toString().equalsIgnoreCase("vapa puli pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.vapa_puli_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("pakkon pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.pakon_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("vapa pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.vapa_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("patishapta")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.patishapta));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("Chitoi Pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.chitoi_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("khir puli")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.khir_puli));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("shamuk pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.samuk_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("chui pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.chui_pitha));
            }
            else if (pitha_name_text_view.getText().toString().equalsIgnoreCase("pata pitha")){
                pithaImage.setImageDrawable(getResources().getDrawable(R.drawable.patapitha));
            }
        }

        showAmount = calculateAmount(pitha_name_text_view.getText().toString().trim(),pitha_amount.getText().toString().trim());
        tk_textView.setText(showAmount);


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
}
