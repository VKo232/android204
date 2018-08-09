package com.vpumlmodel.stock;

public class stockInfo {

	com.vpumlmodel.stock.stock stock;
	private int ID;
	private java.sql.Date entryDateDisplay;
	private long entryDateL;
	private float fopen;
	private float fclose;
	private float high;
	private float low;
	private float volume;
	private float adjustClose;
	private int StockID;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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

	public float getFopen() {
		return this.fopen;
	}

	public void setFopen(float fopen) {
		this.fopen = fopen;
	}

	public float getFclose() {
		return this.fclose;
	}

	public void setFclose(float fclose) {
		this.fclose = fclose;
	}

	public float getHigh() {
		return this.high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return this.low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getVolume() {
		return this.volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	public float getAdjustClose() {
		return this.adjustClose;
	}

	public void setAdjustClose(float adjustClose) {
		this.adjustClose = adjustClose;
	}

	public int getStockID() {
		return this.StockID;
	}

	public void setStockID(int StockID) {
		this.StockID = StockID;
	}

}