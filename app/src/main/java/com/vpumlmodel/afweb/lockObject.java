package com.vpumlmodel.afweb;

public class lockObject {

	private int ID;
	private String lockName;
	private int type;
	private java.sql.Date lockDateDisplay;
	private long lockDateL;
	private String comment;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getLockName() {
		return this.lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public java.sql.Date getLockDateDisplay() {
		return this.lockDateDisplay;
	}

	public void setLockDateDisplay(java.sql.Date lockDateDisplay) {
		this.lockDateDisplay = lockDateDisplay;
	}

	public long getLockDateL() {
		return this.lockDateL;
	}

	public void setLockDateL(long lockDateL) {
		this.lockDateL = lockDateL;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}