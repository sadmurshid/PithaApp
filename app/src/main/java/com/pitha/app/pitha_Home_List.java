package com.pitha.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class pitha_Home_List extends AppCompatActivity {

    private ListView listView;

    String pitha_name [] = new String[] {"Chitoi Pitha", "puli pitha", "nokshi pitha", "vapa pitha", "patishapta", "khir puli", "shamuk pitha", "chui pitha", "shemai pitha", "Pata Pitha"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitha__home__list);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pitha_name);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String pitha_names = listView.getItemAtPosition(i).toString();
                Intent intent = new Intent(getApplicationContext(),pitha_order.class);
                intent.putExtra("pitha_name", pitha_names);
                startActivity(intent);
            }
        });

    }
}
