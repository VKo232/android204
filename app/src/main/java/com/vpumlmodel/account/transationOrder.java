package com.vpumlmodel.account;

public class transationOrder {

	com.vpumlmodel.account.tradingRule tradingRule;
	private int ID;
	private String TRname;
	private int TRsignal;
	private int status;
	private int type;
	private java.sql.Date entryDateDisplay;
	private long entryDateL;
	private float share;
	private float avgPrice;
	private String symbol;
	private int StockID;
	private int AccountID;
	private int TradingRuleID;

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

	public int getTRsignal() {
		return this.TRsignal;
	}

	public void setTRsignal(int TRsignal) {
		this.TRsignal = TRsignal;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public java.sql.Date getEntryDateDisplay() {
		return this.entryDateDisplay;
	}

	public void setEntryDateDisplay(java.sql.Date entryDateDisplay) {
		this.entryDateDisplay = entryDateDisplay;
	}

	public long getEntryDateL() {
		return this.entryDateL;
	}

	public void setEntryDateL(long entryDateL) {
		this.entryDateL = entryDateL;
	}

	public float getShare() {
		return this.share;
	}

	public void setShare(float share) {
		this.share = share;
	}

	public float getAvgPrice() {
		return this.avgPrice;
	}

	public void setAvgPrice(float avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getStockID() {
		return this.StockID;
	}

	public void setStockID(int StockID) {
		this.StockID = StockID;
	}

	public int getAccountID() {
		return this.AccountID;
	}

	public void setAccountID(int AccountID) {
		this.AccountID = AccountID;
	}

	public int getTradingRuleID() {
		return this.TradingRuleID;
	}

	public void setTradingRuleID(int TradingRuleID) {
		this.TradingRuleID = TradingRuleID;
	}

}