package com.techelevator;

import java.util.Scanner;

public class MenuOptions extends AccountUser {



    public void welcomeMenuSignUpSignIn(){
        System.out.println("--------------------------------------------");
        System.out.println("--------Welcome to the Banking App!---------");
        System.out.println("--------------------------------------------");
        System.out.println("(1) - Sign In");
        System.out.println("(2) - Create New Account");
        System.out.print("Enter Here: ");
    }
    public void accountMenu(){
        System.out.println();
//        System.out.println("--------------------------------------------");
//        System.out.println("--------------- Account--------------");
//        System.out.println("--------------------------------------------");
        System.out.println("(1) - View Balance");
        System.out.println("(2) - Withdraw Funds");
        System.out.println("(3) - Transfer Funds");
        System.out.println("(4) - Deposit Funds");
        System.out.println("(5) - Back to Main Menu");
        System.out.print("Enter Here: ");
    }


    public void accountsViewMenu(){

        System.out.println("(1) - View Your Account(s)");
        System.out.println("(2) - Open A New Account");
        System.out.println("(3) - Exit");
        System.out.print("Enter Here: ");
    }

    public void viewAllAccounts(){
        System.out.println("--------------------------------");
        System.out.println("--------Your Account(s)---------");
        System.out.println("--------------------------------");
    }


    public void createAccountMenu(){
        System.out.println();
        System.out.println("Select the type of account you want to create: ");
        System.out.println("(1) - Checkings Account");
        System.out.println("(2) - Savings Account");
        System.out.println("(3) - Exit");
        System.out.print("Enter Here:  ");
    }




    public void pause() {
        System.out.println();
        System.out.println("Press Enter to continue...");

    }

    public void viewBalance(){
        System.out.println();
        System.out.println("Your Current Account Balance is: ");
    }
    public void invalidEntry(){
        System.out.println();
        System.out.println("Invalid entry. Please try again.");
    }

}
