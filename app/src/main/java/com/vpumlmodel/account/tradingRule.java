package com.vpumlmodel.account;

public class tradingRule {

	account account;
	transationOrder[] transationOrder;
	private int ID;
	private String TRname;
	private int type;
	private int status;
	private int subStatus;
	private int TRsignal;
	private java.sql.Date updateDateDisplay;
	private long updateDateL;
	private float share;
	private float amount;
	private float shortShare;
	private float shortAmount;
	private int linkTradingRuleID;
	private int AccountID;
	private int StockID;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTRname() {
		return this.TRname;
	}

	public void setTRname(String TRname) {
		this.TRname = TRname;
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

	public int getTRsignal() {
		return this.TRsignal;
	}

	public void setTRsignal(int TRsignal) {
		this.TRsignal = TRsignal;
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

	public float getShare() {
		return this.share;
	}

	public void setShare(float share) {
		this.share = share;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getShortShare() {
		return this.shortShare;
	}

	public void setShortShare(float shortShare) {
		this.shortShare = shortShare;
	}

	public float getShortAmount() {
		return this.shortAmount;
	}

	public void setShortAmount(float shortAmount) {
		this.shortAmount = shortAmount;
	}

	public int getLinkTradingRuleID() {
		return this.linkTradingRuleID;
	}

	public void setLinkTradingRuleID(int linkTradingRuleID) {
		this.linkTradingRuleID = linkTradingRuleID;
	}

	public int getAccountID() {
		return this.AccountID;
	}

	public void setAccountID(int AccountID) {
		this.AccountID = AccountID;
	}

	public int getStockID() {
		return this.StockID;
	}

	public void setStockID(int StockID) {
		this.StockID = StockID;
	}

}