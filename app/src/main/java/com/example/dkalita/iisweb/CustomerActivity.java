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
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    private static final String TAG = "CustomerA";
    private  CustomerObj customerObj;
    private  String customerObjSt;
    private  ArrayList <AccountObj> accountObjList;
    private  String accountObjListSt;

    private String[] accountList = { ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            setCustomerObjSt(getIntent().getStringExtra("customerObjSt"));
            setCustomerObj(objectMapper.readValue(getCustomerObjSt(), CustomerObj.class));

            setCustomerObjSt(getIntent().getStringExtra("customerObjSt"));
            setCustomerObj(objectMapper.readValue(getCustomerObjSt(), CustomerObj.class));

            setAccountObjListSt(getIntent().getStringExtra("accountObjListSt"));
            AccountObj[] arrayItem = new ObjectMapper().readValue(getAccountObjListSt(), AccountObj[].class);
            List<AccountObj> listItem = Arrays.<AccountObj>asList(arrayItem);
            setAccountObjList(new ArrayList<AccountObj>(listItem));

            ArrayList resultsObjects = new ArrayList();
            String custInfo = customerObj.getEmail();
            if (custInfo  == null) {
                custInfo = customerObj.getUserName();
            }


            resultsObjects.add("Customer: "+custInfo);
            for (int i=0; i<accountObjList.size(); i++ ) {
                AccountObj accObj = accountObjList.get(i);
                resultsObjects.add("     "+accObj.getAccountName());
            }

            String  accountL[] = (String[]) resultsObjects.toArray(new String[resultsObjects.size()]);
            setAccountList(accountL);

        } catch (IOException e) {
            e.printStackTrace();
        }



        final ListView lv = (ListView) findViewById(R.id.listv1);

        // Create an ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, getAccountList()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                if (position == 0 ) {
                    // Set the text color of TextView (ListView Item)
                    tv.setBackgroundColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLUE);
                }

                // Generate ListView Item using TextView
                return view;
            }

        };


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                if (position == 0 ) { // disable the first item
                    return;
                }
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                if (position < accountObjList.size()+1) {

                    try {

                        AccountObj accObj = accountObjList.get(position-1);
                        Intent myIntent = new Intent(getApplicationContext(), AccountStockActivityHandler.class);

                        myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters

                        String accountObjSt = new ObjectMapper().writeValueAsString(accObj);
                        myIntent.putExtra("accountObjSt", accountObjSt); //Optional parameters

                        myIntent.putExtra(PromptDialogFragment.ADD_SYM_CMD, ""); //Optional parameters
                        myIntent.putExtra(PromptDialogFragment.DEL_SYM_CMD, "");

                        startActivity(myIntent);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

        });
        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

    }


    public CustomerObj getCustomerObj() {
        return customerObj;
    }

    public void setCustomerObj(CustomerObj customerObj) {
        this.customerObj = customerObj;
    }

    public ArrayList<AccountObj> getAccountObjList() {
        return accountObjList;
    }

    public void setAccountObjList(ArrayList<AccountObj> accountObjList) {
        this.accountObjList = accountObjList;
    }

    public String getCustomerObjSt() {
        return customerObjSt;
    }

    public void setCustomerObjSt(String customerObjSt) {
        this.customerObjSt = customerObjSt;
    }

    public String getAccountObjListSt() {
        return accountObjListSt;
    }

    public void setAccountObjListSt(String accountObjListSt) {
        this.accountObjListSt = accountObjListSt;
    }

    public String[] getAccountList() {
        return accountList;
    }

    public void setAccountList(String[] accountList) {
        this.accountList = accountList;
    }
}
