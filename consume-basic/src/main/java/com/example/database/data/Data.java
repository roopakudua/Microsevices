package com.example.database.data;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	private String id ;
	private String name;
	private int exp;
	private String accNO;
	private int sal;
	private String bankName;
	
	public Data() {
		
	}
	
	public Data(String id, String name, int exp, String accNO, int sal, String bankName) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
		this.accNO = accNO;
		this.sal = sal;
		this.bankName = bankName;
	}

	
	
	public String getId() {
		return id;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getExp() {
		return exp;
		
	}
	
	public void setId(String id) {
		this.id = id;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
		
	}
	public String getAccNO() {
		return accNO;
	}

	public void setAccNO(String accNO) {
		this.accNO = accNO;
	}
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getbankName() {
		return bankName;
	}

	public void setbankName(String bankName) {
		this.bankName = bankName;
	}


}
