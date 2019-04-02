package com.idexcel.restapi.IdexcelRest.accountstore;

/*
 * 
 * Entity Class Defined for Account 
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sbaccount")
@ApiModel
public class Account {
	
    @Id
    @Column(name="accountNumber")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated account ID")
	private long accountNumber;
    
    @Column(name="accountholderName")
    @ApiModelProperty(notes = "The accountholderName")
    private String accountholderName;
    
    @Column(name="Address")
    @ApiModelProperty(notes = "Address of the specific accountHolder")
    private String Address;
    
    @Column(name="phoneNumber")
    @ApiModelProperty(notes = "Phone number of accountHolder")
    private long phoneNumber;
    
    public Account() {
    	
    }
    
    public Account(long accountNumber, String accountholderName,String Address, long phoneNumber) {
    	this.accountNumber = accountNumber;
    	this.accountholderName= accountholderName;
    	this.Address = Address;
    	this.phoneNumber= phoneNumber;
    }
    
    public long getAccountNumber() {
    	return this.accountNumber;
    }
    
    public String getAccountHolderName() {
    	return this.accountholderName;
    }
    
    public String getAddress() {
    	return this.Address;
    }
    public long getphonenUmber() {
    	return this.phoneNumber;
    }
    public void setAccountNumber(long accountNumber) {
    	this.accountNumber= accountNumber;
    }
    
    public void setAccountHolderName(String accountholderName) {
    	this.accountholderName= accountholderName;
    }
    
    public void setAddress(String Address) {
    	this.Address= Address;
    }
    public void setphoneNumber(long phoneNumber) {
    	this.phoneNumber= phoneNumber;
    }

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountholderName=" + accountholderName + ", Address=" + Address
				+ ", phoneNumber=" + phoneNumber + "]";
	}    
}
