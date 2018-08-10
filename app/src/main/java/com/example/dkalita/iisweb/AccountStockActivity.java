package com.example.dkalita.iisweb;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.afweb.model.stock.AFstockObj;
import com.example.dkalita.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountStockActivity extends AppCompatActivity  implements OnDialogDoneListener{
    private static final String TAG = "AccountStockA";
    private  CustomerObj customerObj;
    private  String customerObjSt;

    private  ArrayList <AccountObj> accountObjList;
    private  String accountObjListSt;
    private  AccountObj accountObj;

    private ArrayList <AFstockObj> accountStockList;
    private  String accountStockListSt;

    private String stAccountName;
    private String stToastmsg;

    private String[] stockList = { ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountstock);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


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

            setAccountStockListSt(getIntent().getStringExtra("accountStockListSt"));
            AFstockObj[] arrayItem1 = new ObjectMapper().readValue(getAccountStockListSt(), AFstockObj[].class);
            List<AFstockObj> listItem1 = Arrays.<AFstockObj>asList(arrayItem1);
            setAccountStockList(new ArrayList<AFstockObj>(listItem1));

            stToastmsg =getIntent().getStringExtra("Toastmsg");

            String accInfo = getAccountObj().getAccountName();
            stAccountName = "Account: "+accInfo;
            resultsObjects.add(stAccountName);

            for (int i=0; i<getAccountStockList().size(); i++ ) {
                AFstockObj stockObj = getAccountStockList().get(i);
                String s = String.format("     %-15s%10s%10s%10s", stockObj.getSymbol(),"S="+stockObj.getShortTerm(), "L="+stockObj.getLongTerm(), "D="+stockObj.getDirection());

                resultsObjects.add(s);
            }

            String  stockList[] = (String[]) resultsObjects.toArray(new String[resultsObjects.size()]);
            setStockList(stockList);

        } catch (IOException e) {
            e.printStackTrace();
        }


        final ListView lv =  findViewById(R.id.liststockv1);

        final Button addbtn =  findViewById(R.id.addline);
        final Button delbtn =  findViewById(R.id.deleteline);
        final Button refreshbn1 = findViewById(R.id.refreshbn1);

        String  stockList[] = (String[]) resultsObjects.toArray(new String[resultsObjects.size()]);

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, getStockList()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.BLUE);
//                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, 36);
                // Generate ListView Item using TextView
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

                if (position < accountStockList.size()+1) {

                    try {

                        AFstockObj stockObj = accountStockList.get(position-1);
                        Intent myIntent = new Intent(getApplicationContext(), TrandingRuleActivityHandler.class);

                        myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters
                        myIntent.putExtra("accountObjListSt", accountObjListSt); //Optional parameters
                        myIntent.putExtra("accountObjId", accountObj.getID());

                        String stockObjSt = new ObjectMapper().writeValueAsString(stockObj);
                        myIntent.putExtra("stockObjSt", stockObjSt); //Optional parameters

                        startActivity(myIntent);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }

        });
        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List

                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                /*
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */
                arrayAdapter.notifyDataSetChanged();
                //start the prompt
                addSymbolPromptDialog();
            }
        });

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List

                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                /*
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */
                arrayAdapter.notifyDataSetChanged();
                //start the prompt
                delSymbolPromptDialog();
            }
        });

        refreshbn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List

//                Toast.makeText(getApplicationContext(),
//                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                /*
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */
                arrayAdapter.notifyDataSetChanged();
                Intent myIntent = new Intent(getApplicationContext(), AccountStockActivityHandler.class);

                myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters
                myIntent.putExtra("accountObjListSt", accountObjListSt); //Optional parameters
                myIntent.putExtra("accountObjId", accountObj.getID());
                myIntent.putExtra(PromptDialogFragment.ADD_SYM_CMD, "");
                myIntent.putExtra(PromptDialogFragment.DEL_SYM_CMD, "");
                startActivity(myIntent);
            }
        });


        if (stToastmsg != null) {
            if (stToastmsg.length() >0){
                Toast.makeText(this, stToastmsg, Toast.LENGTH_LONG).show();
            }
        }

    }


    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
        Intent myIntent = new Intent(getApplicationContext(), CustomerActivity.class);

        myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters
        myIntent.putExtra("accountObjListSt", accountObjListSt); //Optional parameters

        startActivity(myIntent);

        finish();
        return true;
//        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void addSymbolPromptDialog()
    {
        FragmentTransaction ft =
                getFragmentManager().beginTransaction();

        PromptDialogFragment pdf =
                PromptDialogFragment.newInstance(
                        "Enter Symbol to Add");

        pdf.show(ft, PromptDialogFragment.ADD_SYM_CMD);
    }

    private void delSymbolPromptDialog()
    {
        FragmentTransaction ft =
                getFragmentManager().beginTransaction();

        PromptDialogFragment pdf =
                PromptDialogFragment.newInstance(
                        "Enter Symbol to Remove");

        pdf.show(ft, PromptDialogFragment.DEL_SYM_CMD);
    }


    public void onDialogDone(String tag, boolean cancelled, CharSequence message) {
        String s = tag + " responds with: " + message;
        if(cancelled) {
            s = tag + " was cancelled by the user";
        }
//        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        Log.i(TAG, s);

        if (cancelled == false) {
            Intent myIntent = new Intent(getApplicationContext(), AccountStockActivityHandler.class);

            myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters
            myIntent.putExtra("accountObjListSt", accountObjListSt); //Optional parameters
            myIntent.putExtra("accountObjId", accountObj.getID());
            String symbol = "" + message;
            if (tag.equals(PromptDialogFragment.ADD_SYM_CMD)) {
                myIntent.putExtra(PromptDialogFragment.ADD_SYM_CMD, symbol); //Optional parameters
                myIntent.putExtra(PromptDialogFragment.DEL_SYM_CMD, "");
            }else {
                myIntent.putExtra(PromptDialogFragment.ADD_SYM_CMD, ""); //Optional parameters
                myIntent.putExtra(PromptDialogFragment.DEL_SYM_CMD, symbol);
            }

            startActivity(myIntent);
        }



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

    public ArrayList<AFstockObj> getAccountStockList() {
        return accountStockList;
    }

    public void setAccountStockList(ArrayList<AFstockObj> accountStockList) {
        this.accountStockList = accountStockList;
    }

    public String getAccountStockListSt() {
        return accountStockListSt;
    }

    public void setAccountStockListSt(String accountStockListSt) {
        this.accountStockListSt = accountStockListSt;
    }

    public String[] getStockList() {
        return stockList;
    }

    public void setStockList(String[] stockList) {
        this.stockList = stockList;
    }

}
