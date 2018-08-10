package com.example.dkalita.iisweb;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.afweb.model.account.TradingRuleObj;
import com.afweb.model.stock.AFstockObj;
import com.example.dkalita.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrandingRuleActivity extends AppCompatActivity {
    private static final String TAG = "TrandingRuleA";
    private CustomerObj customerObj;
    private  String customerObjSt;

    private  ArrayList <AccountObj> accountObjList;
    private  String accountObjListSt;
    private  AccountObj accountObj;

    private ArrayList <TradingRuleObj> tradingRuleObjList;
    private String tradingRuleObjListSt;
    private AFstockObj mAFstockObj;
    private String mAFstockObjSt;

    private String[] trList = { ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradingrule);

        ArrayList resultsObjects = new ArrayList();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            setCustomerObjSt(getIntent().getStringExtra("customerObjSt"));
            setCustomerObj(objectMapper.readValue(getCustomerObjSt(), CustomerObj.class));

            accountObjListSt = (getIntent().getStringExtra("accountObjListSt"));
            AccountObj[] arrayItem = new ObjectMapper().readValue(accountObjListSt, AccountObj[].class);
            List<AccountObj> listItem = Arrays.<AccountObj>asList(arrayItem);
            accountObjList = (new ArrayList<AccountObj>(listItem));

            int accountObjId = getIntent().getIntExtra("accountObjId",0);

            for (int i=0; i<accountObjList.size(); i++) {
                AccountObj accountObjTemp = accountObjList.get(i);
                if (accountObjTemp.getID() == accountObjId) {
                    accountObj= accountObjTemp;
                    break;
                }
            }

            tradingRuleObjListSt = getIntent().getStringExtra("tradingRuleObjListSt");
            TradingRuleObj[] arrayItem1 = new ObjectMapper().readValue(tradingRuleObjListSt, TradingRuleObj[].class);
            List<TradingRuleObj> listItem1 = Arrays.<TradingRuleObj>asList(arrayItem1);
            tradingRuleObjList = new ArrayList<TradingRuleObj>(listItem1);

            mAFstockObjSt = getIntent().getStringExtra("mAFstockObjSt");
            mAFstockObj =objectMapper.readValue(mAFstockObjSt, AFstockObj.class);

            String accInfo = getAccountObj().getAccountName();
            String stAccountName = "Account: "+accInfo +" - "+mAFstockObj.getSymbol()+" "+mAFstockObj.getStockName();
            resultsObjects.add(stAccountName);

            for (int i=0; i<tradingRuleObjList.size(); i++ ) {
                TradingRuleObj tradingRuleObj = tradingRuleObjList.get(i);
                String s = String.format("     %-15s", tradingRuleObj.getTRname());

                resultsObjects.add(s);
            }

            trList = (String[]) resultsObjects.toArray(new String[resultsObjects.size()]);

        } catch (IOException e) {
            e.printStackTrace();
        }


        final ListView lv = (ListView) findViewById(R.id.listtrv1);

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, trList){
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
                return view;
            }

        };


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                if (position == 0) {
                    return;
                }
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

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

    public String getCustomerObjSt() {
        return customerObjSt;
    }

    public void setCustomerObjSt(String customerObjSt) {
        this.customerObjSt = customerObjSt;
    }

    public AccountObj getAccountObj() {
        return accountObj;
    }

    public void setAccountObj(AccountObj accountObj) {
        this.accountObj = accountObj;
    }


}
