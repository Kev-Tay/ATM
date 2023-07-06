package com.techelevator;

public class Account {
    private String accountType;
    private String accountName;
    private int accountNumber;
    private double accountBalance;



    public int setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
        return accountNumber;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double setAccountBalance(double accountBalance){
        this.accountBalance = accountBalance;
        return accountBalance;
    }
    public double getAccountBalance(){
        return accountBalance;
    }
    public String setAccountType(String accountType){
        this.accountType = accountType;
        return accountType;
    }
    
    public String getAccountType(){
        return accountType;
    }

    public String setAccountName(){
        this.accountName= accountName;
        return accountName;
    }

    public String getAccountName(){
        return accountName;
    }

    public double withdrawFromAccount(double withdrawalAmount){
         return accountBalance = (accountBalance - withdrawalAmount);
    }

    public double depositIntoAccount(double depositAmount){
        return accountBalance = (accountBalance + depositAmount);

    }

    public Account(String accountName, String accountType, Double accountBalance){
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
    public Account(){}
}
