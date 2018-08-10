package com.example.dkalita.iisweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.afweb.model.account.TradingRuleObj;
import com.afweb.model.stock.AFstockObj;
import com.example.dkalita.R;
import com.example.dkalita.signin.signin.SignInModel;
import com.example.dkalita.signin.signin.SignInWorkerFragment;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrandingRuleActivityHandler extends AppCompatActivity implements SignInModel.Observer {
    private static final String TAG = "TrandingRuleAH";
    private static final String TAG_WORKER = "TAG_WORKER_TR_ST";
    private CustomerObj customerObj;
    private  String customerObjSt;

    private  ArrayList <AccountObj> accountObjList;
    private  String accountObjListSt;
    private  AccountObj accountObj;

    private AFstockObj stockObj;
    private  String stockObjSt;

    private SignInModel mSignInModel;
    private View mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradingrule);
        mProgress = findViewById(R.id.view_progress_trlist);
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

            stockObjSt = getIntent().getStringExtra("stockObjSt");
            stockObj = objectMapper.readValue(stockObjSt, AFstockObj.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        final SignInWorkerFragment retainedWorkerFragment =
                (SignInWorkerFragment) getFragmentManager().findFragmentByTag(TAG_WORKER);

        if (retainedWorkerFragment != null) {
            mSignInModel = retainedWorkerFragment.getSignInModel();
        } else {
            final SignInWorkerFragment workerFragment = new SignInWorkerFragment();

            getFragmentManager().beginTransaction()
                    .add(workerFragment, TAG_WORKER)
                    .commit();

            mSignInModel = workerFragment.getSignInModel();
        }
        mSignInModel.registerObserver(this);

        mSignInModel.signInTrandingRule(getCustomerObj().getUserName(), "" + getAccountObj().getID(), stockObj.getSymbol());

    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
        mSignInModel.unregisterObserver(this);

        if (isFinishing()) {
            mSignInModel.stopSignIn();
        }
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
    }

//	@Override
//	protected void onPause() {
//		Log.i(TAG, "onPause");
//		super.onResume();
//	}

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onSignInStarted(final SignInModel signInModel) {
        Log.i(TAG, "onSignInStarted");
        showProgress(true);
    }

    @Override
    public void onSignInSucceeded(final SignInModel signInModel) {
        Log.i(TAG, "onSignInSucceeded");
        finish();

        try {

            ArrayList <TradingRuleObj> tradingRuleObjList = signInModel.getTradingRuleObjList();
            if (tradingRuleObjList != null) {
                Intent myIntent = new Intent(getApplicationContext(), TrandingRuleActivity.class);

                myIntent.putExtra("customerObjSt", customerObjSt); //Optional parameters
                myIntent.putExtra("accountObjListSt", accountObjListSt); //Optional parameters
                myIntent.putExtra("accountObjId", accountObj.getID());

                String tradingRuleObjListSt = new ObjectMapper().writeValueAsString(tradingRuleObjList);
                myIntent.putExtra("tradingRuleObjListSt", tradingRuleObjListSt); //Optional parameters

                AFstockObj mAFstockObj = signInModel.getmAFstockObj();
                String mAFstockObjSt = new ObjectMapper().writeValueAsString(mAFstockObj);
                myIntent.putExtra("mAFstockObjSt", mAFstockObjSt); //Optional parameters

                startActivity(myIntent);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onSignInFailed(final SignInModel signInModel) {
        Log.i(TAG, "onSignInFailed");
        showProgress(false);
    }

    private void showProgress(final boolean show) {
        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
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
