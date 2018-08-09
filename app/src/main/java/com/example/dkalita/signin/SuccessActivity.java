package com.example.dkalita.signin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.example.dkalita.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuccessActivity extends Activity {
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_success);


		CustomerObj custObj = null;
		ArrayList<AccountObj> accountObjList = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String customerObjSt = getIntent().getStringExtra("customerObjSt");
			custObj  = objectMapper.readValue(customerObjSt, CustomerObj.class);

			String accountObjListSt = getIntent().getStringExtra("accountObjListSt");
			AccountObj[] arrayItem = new ObjectMapper().readValue(accountObjListSt, AccountObj[].class);
			List<AccountObj> listItem = Arrays.<AccountObj>asList(arrayItem);
			accountObjList = new ArrayList<AccountObj>(listItem);

		} catch (IOException e) {
			e.printStackTrace();
		}

		setContentView(R.layout.activity_success);
		if (custObj != null) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("Login Successful");
			sBuilder.append("\nUsername:" + custObj.getUserName());

			if (accountObjList != null) {
				sBuilder.append("\n\nAccount");
				for (int i=0; i< accountObjList.size(); i++) {
					AccountObj accObj = accountObjList.get(i);
					sBuilder.append("\nAccount Name:" + accObj.getAccountName() + " "+ accObj.getID());
				}
			}

			TextView mDisplayData = (TextView) findViewById(R.id.success_displayData);
			mDisplayData.setText(sBuilder.toString() + "\n\n");
		}
	}
}