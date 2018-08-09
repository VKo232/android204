package com.example.dkalita.signin.communicator;

import android.app.Activity;

import com.afweb.model.account.AccountObj;
import com.afweb.model.account.CustomerObj;
import com.afweb.model.stock.AFstockObj;

import java.util.ArrayList;

public interface BackendCommunicator {
	boolean postSignIn(String userName, String password) throws InterruptedException;

	public CustomerObj getCustomerObj (String gEmail, String gPass)throws Exception;
	public ArrayList getAccountList(String gUserName, String gPass)throws Exception;
	public AccountObj getAccountObj(String gUserName, String gAccountId)throws Exception;
	public ArrayList getAccountStockList(String gUserName, String gAccountId)throws Exception;
	public int getAccountAddStockList(String gUserName, String gAccountId, String gSymbol)throws Exception;
	public int getAccountRemoveStockList(String gUserName, String gAccountId, String gSymbol)throws Exception;
	public ArrayList getTradingRuleList(String gUserName, String gAccountId, String gSymbol)throws Exception;
    public AFstockObj geAFstockObj(String gSymbol)throws Exception;


}
