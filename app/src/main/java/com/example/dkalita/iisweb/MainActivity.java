package com.example.dkalita.iisweb;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.example.dkalita.R;
import com.example.dkalita.signin.signin.SignInActivity;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] optionList = { ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList resultsObjects = new ArrayList();
        resultsObjects.add("Login");  // position 0
        resultsObjects.add(" ");
        resultsObjects.add("Register New Customer"); // position 2
        resultsObjects.add(" ");
        resultsObjects.add("Enter Demo Accocunt Without Login"); // position 4
        optionList = (String[]) resultsObjects.toArray(new String[resultsObjects.size()]);

        final ListView lv = (ListView) findViewById(R.id.listmainv1);

        // Create an ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, optionList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.BLUE);
//                if (position == 0 ) {
//                    // Set the text color of TextView (ListView Item)
//                    tv.setBackgroundColor(Color.GRAY);
//                }

                // Generate ListView Item using TextView
                return view;
            }

        };


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

//                // When clicked, show a toast with the TextView text
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    myIntent.putExtra("gLogin", "");
                    myIntent.putExtra("gPass", "");
                    startActivity(myIntent);
                } else if (position == 4) {
                    Intent myIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    myIntent.putExtra("gLogin", "guest");
                    myIntent.putExtra("gPass", "guest");
                    startActivity(myIntent);
                }
            }
        });
        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

    }


}
