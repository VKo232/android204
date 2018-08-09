package com.example.dkalita.signin.signin;

import android.database.Observable;
import android.os.AsyncTask;
import android.util.Log;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.afweb.model.stock.AFstockObj;
import com.example.dkalita.signin.communicator.BackendCommunicator;
import com.example.dkalita.signin.communicator.communicatorFactory;

import java.util.ArrayList;

public class SignInModel {
	private static final String TAG = "SignInModel";

	private final SignInObservable mObservable = new SignInObservable();
	private SignInTask mSignInTask;
	private boolean mIsWorking;

    private CustomerObj customerObj;
	private ArrayList <AccountObj> accountObjList;

	private ArrayList <AFstockObj> accountStockList;
	private AccountObj accountObj;

	private int ResultAddRemoveStock;

	public SignInModel() {
		Log.i(TAG, "new Instance");
	}

	public void signIn(final String userName, final String password) {
		if (mIsWorking) {
			return;
		}

		mObservable.notifyStarted();

		mIsWorking = true;
		setmSignInTask(new SignInTask());
		getmSignInTask().setCustimerTask(userName, password);
		getmSignInTask().execute();
	}



	public void signInAccountStock(final String userName, final String accountId) {
		if (mIsWorking) {
			return;
		}

		mObservable.notifyStarted();
		mIsWorking = true;
		setmSignInTask(new SignInTask());
		getmSignInTask().setAccountStockTask(userName, accountId);
		getmSignInTask().execute();
	}

	public void signInAccountAddStock(final String userName, final String accountId, final String symbol) {
		if (mIsWorking) {
			return;
		}

		mObservable.notifyStarted();
		mIsWorking = true;
		setmSignInTask(new SignInTask());
		getmSignInTask().setAccountAddStockTask(userName, accountId, symbol);
		getmSignInTask().execute();
	}


	public void signInAccountRemoveStock(final String userName, final String accountId, final String symbol) {
		if (mIsWorking) {
			return;
		}

		mObservable.notifyStarted();
		mIsWorking = true;
		setmSignInTask(new SignInTask());
		getmSignInTask().setAccountRemoveStockTask(userName, accountId, symbol);
		getmSignInTask().execute();
	}

	public void stopSignIn() {
		if (mIsWorking) {
			getmSignInTask().cancel(true);
			mIsWorking = false;
		}
	}

	public void registerObserver(final Observer observer) {
		mObservable.registerObserver(observer);
		if (mIsWorking) {
			observer.onSignInStarted(this);
		}
	}

	public void unregisterObserver(final Observer observer) {
		mObservable.unregisterObserver(observer);
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

	//android.os.AsyncTask<Params, Progress, Result>
	//https://alvinalexander.com/android/asynctask-examples-parameters-callbacks-executing-canceling

	public static final int IISWEB_GET_CUSTOMER_SIGNIN = 0;
	public static final int IISWEB_GET_ACCOUNTSTOCKLIST = 2;
	public static final int IISWEB_GET_ACCOUNTADDSTOCKLIST = 4;
	public static final int IISWEB_GET_ACCOUNTREMOVESTOCKLIST = 5;


	public ArrayList<AFstockObj> getAccountStockList() {
		return accountStockList;
	}

	public void setAccountStockList(ArrayList<AFstockObj> accountStockList) {
		this.accountStockList = accountStockList;
	}

	public SignInTask getmSignInTask() {
		return mSignInTask;
	}

	public void setmSignInTask(SignInTask mSignInTask) {
		this.mSignInTask = mSignInTask;
	}

	public int getResultAddRemoveStock() {
		return ResultAddRemoveStock;
	}

	public void setResultAddRemoveStock(int resultAddRemoveStock) {
		ResultAddRemoveStock = resultAddRemoveStock;
	}

	public class SignInTask extends AsyncTask<Void, Void, Integer> {
		private String mUserName;
		private String mPassword;
		private String mAccountId;
		private String mSymbol;

		private int mIISWebfunction;

		public SignInTask() {

		}

		public void setCustimerTask(final String userName, final String password) {
			mUserName = userName;
			mPassword = password;
			setCustomerObj(null);
			setmIISWebfunction(IISWEB_GET_CUSTOMER_SIGNIN);
		}

		public void setAccountStockTask(final String userName, final String accountId) {
			mUserName = userName;
			mAccountId = accountId;
			setAccountStockList(null);
			setmIISWebfunction(IISWEB_GET_ACCOUNTSTOCKLIST);
		}



		public void setAccountAddStockTask(final String userName, final String accountId, final String symbol) {
			mUserName = userName;
			mAccountId = accountId;
			setmSymbol(symbol);
			setResultAddRemoveStock(0);
			setmIISWebfunction(IISWEB_GET_ACCOUNTADDSTOCKLIST);
		}

		public void setAccountRemoveStockTask(final String userName, final String accountId, final String symbol) {
			mUserName = userName;
			mAccountId = accountId;
			setmSymbol(symbol);
			setResultAddRemoveStock(0);
			setmIISWebfunction(IISWEB_GET_ACCOUNTREMOVESTOCKLIST);
		}

		@Override
		protected Integer doInBackground(final Void... params) {

			final BackendCommunicator communicator = communicatorFactory.createBackendCommunicator();

			try {

				if (getmIISWebfunction() == IISWEB_GET_CUSTOMER_SIGNIN) {
					CustomerObj custObj = communicator.getCustomerObj(mUserName, mPassword);
					if (custObj == null) {
						return 0;
					}
					setCustomerObj(custObj);
					Log.i(TAG, "Username: " + custObj.getUserName());

					ArrayList accList = communicator.getAccountList(custObj.getUserName(), mPassword);
					if (accList == null) {
						return 0;
					}
					setAccountObjList(accList);
					return 1;

				} else if (getmIISWebfunction() == IISWEB_GET_ACCOUNTSTOCKLIST) {

					ArrayList accountStockList = communicator.getAccountStockList(mUserName, mAccountId);
					if (accountStockList == null) {
						return 0;
					}
					Log.i(TAG, "StockSize: " + accountStockList.size());
					setAccountStockList(accountStockList);
					return 1;

				} else if (getmIISWebfunction() == IISWEB_GET_ACCOUNTADDSTOCKLIST) {

					setResultAddRemoveStock(communicator.getAccountAddStockList(mUserName, mAccountId, getmSymbol()));
					ArrayList accountStockList = communicator.getAccountStockList(mUserName, mAccountId);
					if (accountStockList == null) {
						return 0;
					}
					Log.i(TAG, "StockSize: " + accountStockList.size());
					setAccountStockList(accountStockList);

					if (getResultAddRemoveStock() == 1) {
						return 1;
					}
					return 0;

				} else if (getmIISWebfunction() == IISWEB_GET_ACCOUNTREMOVESTOCKLIST) {

					setResultAddRemoveStock(communicator.getAccountRemoveStockList(mUserName, mAccountId, getmSymbol()));
					ArrayList accountStockList = communicator.getAccountStockList(mUserName, mAccountId);
					if (accountStockList == null) {
						return 0;
					}
					Log.i(TAG, "StockSize: " + accountStockList.size());
					setAccountStockList(accountStockList);
					if (getResultAddRemoveStock() == 1) {
						return 1;
					}
					return 0;

				}
			} catch (Exception e) {
				Log.i(TAG, "Sign in interrupted");

			}
			return 100;
		}

		@Override
		protected void onPostExecute(final Integer success) {
			mIsWorking = false;

			if (success == 1) {
				mObservable.notifySucceeded();
			} else {
				mObservable.notifyFailed();
			}

		}

		public String getmSymbol() {
			return mSymbol;
		}

		public void setmSymbol(String mSymbol) {
			this.mSymbol = mSymbol;
		}

		public int getmIISWebfunction() {
			return mIISWebfunction;
		}

		public void setmIISWebfunction(int mIISWebfunction) {
			this.mIISWebfunction = mIISWebfunction;
		}
	}

	public interface Observer {
		void onSignInStarted(SignInModel signInModel);

		void onSignInSucceeded(SignInModel signInModel);

		void onSignInFailed(SignInModel signInModel);
	}

	private class SignInObservable extends Observable<Observer> {
		public void notifyStarted() {
			for (final Observer observer : mObservers) {
				observer.onSignInStarted(SignInModel.this);
			}
		}

		public void notifySucceeded() {
			for (final Observer observer : mObservers) {
				observer.onSignInSucceeded(SignInModel.this);
			}
		}

		public void notifyFailed() {
			for (final Observer observer : mObservers) {
				observer.onSignInFailed(SignInModel.this);
			}
		}
	}
}