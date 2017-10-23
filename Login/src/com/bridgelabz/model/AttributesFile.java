package com.bridgelabz.model;

public class AttributesFile {
	
	private String userName;
	
	private String password;
	
	private long mobileNumber;
	
	private String emailId;
	
	public AttributesFile() {
		userName=null;
		password=null;
		mobileNumber=0;
		emailId=null;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
}
