package com.vpumlmodel.account;

public class account {

	com.vpumlmodel.afweb.customer customer;
	com.vpumlmodel.account.tradingRule[] tradingRule;
	private int ID;
	private String accountName;
	private int type;
	private int status;
	private int subStatus;
	private java.sql.Date startDate;
	private java.sql.Date updateDateDisplay;
	private long updateDateL;
	private float investment;
	private float balance;
	private float serviceFee;
	private int linkAccountID;
	private int CustomerID;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSubStatus() {
		return this.subStatus;
	}

	public void setSubStatus(int subStatus) {
		this.subStatus = subStatus;
	}

	public java.sql.Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getUpdateDateDisplay() {
		return this.updateDateDisplay;
	}

	public void setUpdateDateDisplay(java.sql.Date updateDateDisplay) {
		this.updateDateDisplay = updateDateDisplay;
	}

	public long getUpdateDateL() {
		return this.updateDateL;
	}

	public void setUpdateDateL(long updateDateL) {
		this.updateDateL = updateDateL;
	}

	public float getInvestment() {
		return this.investment;
	}

	public void setInvestment(float investment) {
		this.investment = investment;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getServiceFee() {
		return this.serviceFee;
	}

	public void setServiceFee(float serviceFee) {
		this.serviceFee = serviceFee;
	}

	public int getLinkAccountID() {
		return this.linkAccountID;
	}

	public void setLinkAccountID(int linkAccountID) {
		this.linkAccountID = linkAccountID;
	}

	public int getCustomerID() {
		return this.CustomerID;
	}

	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}

}