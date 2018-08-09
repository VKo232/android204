package com.vpumlmodel.afweb;

import com.vpumlmodel.account.account;

public class customer {

	account[] account;
	private int ID;
	private String userName;
	private String password;
	private int type;
	private int status;
	private int subStatus;
	private java.sql.Date startDate;
	private String firstName;
	private String lastName;
	private String email;
	private float balance;
	private java.sql.Date updateDateDisplay;
	private long updateDateL;

	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
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

}