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
	
	public void setUserName(String userName) {
		this.userName=userName;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setMobileNo(long mobileNumber) {
		this.mobileNumber=mobileNumber;
	}
	
	public void setEmailID(String emailId) {
		this.emailId=emailId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	
	public String getEmailID() {
		return emailId;
	}
}
