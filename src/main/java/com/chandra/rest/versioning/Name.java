package com.chandra.rest.versioning;

public class Name {

	private String fName;
	private String sName;
	
	public Name(String fName, String sName) {
		super();
		this.fName = fName;
		this.sName = sName;
	}
	public Name() {
		super();
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return String.format("Name [fName=%s, sName=%s]", fName, sName);
	}
	
}
