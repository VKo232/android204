package com.vpumlmodel.stock;

public class stock {

	stockInfo[] stockInfo;
	private int ID;
	private String symbol;
	private String stockName;
	private int status;
	private int subStatus;
	private java.sql.Date updateDateDisplay;
	private long updateDateL;
	private int failedUpdate;
	private float longTerm;
	private float shortTerm;
	private float direction;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
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

	public int getFailedUpdate() {
		return this.failedUpdate;
	}

	public void setFailedUpdate(int failedUpdate) {
		this.failedUpdate = failedUpdate;
	}

	public float getLongTerm() {
		return this.longTerm;
	}

	public void setLongTerm(float longTerm) {
		this.longTerm = longTerm;
	}

	public float getShortTerm() {
		return this.shortTerm;
	}

	public void setShortTerm(float shortTerm) {
		this.shortTerm = shortTerm;
	}

	public float getDirection() {
		return this.direction;
	}

	public void setDirection(float direction) {
		this.direction = direction;
	}

}