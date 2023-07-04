package com.techelevator;

import javax.swing.*;
import java.util.*;

public class Main extends AccountUser {
    private final MenuOptions menuOptions = new MenuOptions();

    Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    HashMap<String, String> UsernameAndPassword = new HashMap<String, String>();
    List<Account> accounts = new ArrayList<>();

    private void run() {
        menuOptions.welcomeMenuSignUpSignIn();
        UsernameAndPassword.put("Username", "Password");


        String userSelection = userInput.nextLine();
        while (!userSelection.equals("1") && !userSelection.equals("2")) {
            menuOptions.invalidEntry();
            menuOptions.pause();
            userInput.nextLine();
            menuOptions.welcomeMenuSignUpSignIn();
            System.out.print("Enter Here: ");
            userSelection = userInput.nextLine();
        }
        if (userSelection.equals("1")) {                                                                                        //LOGIN WITH EXISTING ACCOUNT
            System.out.println();
            System.out.print("Enter Username: ");
            String inputUsername = userInput.nextLine();
            setUsername(inputUsername);
            System.out.print("Enter Password: ");
            String inputPassword = userInput.nextLine();
            setUserPassword(inputPassword);
        } else {                                                                                                                //CREATE NEW USER ACCOUNT
            System.out.println();
            System.out.print("Create Username: ");
            String inputUsername = userInput.nextLine();
            System.out.print("Create Password: ");
            String inputPassword = userInput.nextLine();
            AccountUser user = new AccountUser(inputUsername, inputPassword);
            setUsername(inputUsername);
            setUserPassword(inputPassword);
            UsernameAndPassword.put(inputUsername, inputPassword);
            System.out.println();
            System.out.println("Your account has been created.");
            menuOptions.pause();
            userInput.nextLine();
        }
        for (Map.Entry<String, String> entry : UsernameAndPassword.entrySet()) {

            while (!Objects.equals(entry.getKey(), getUsername()) || !Objects.equals(entry.getValue(), getUserPassword())) {
                System.out.println("Wrong username and/or password. Please try again");
                System.out.println();
                System.out.print("Enter Username: ");
                String inputUsername = userInput.nextLine();
                setUsername(inputUsername);
                System.out.print("Enter Password: ");
                String inputPassword = userInput.nextLine();
                setUserPassword(inputPassword);
                UsernameAndPassword.put(inputUsername, inputPassword);
            }
            System.out.println();                                                                                           //LOGGED IN
            System.out.println("Hello, " + getUsername());
            while (Objects.equals(entry.getKey(), getUsername()) && Objects.equals(entry.getValue(), getUserPassword())) {
                System.out.println();

                menuOptions.accountsViewMenu();
                userSelection = userInput.nextLine();

                while (!userSelection.equals("1") && !userSelection.equals("2") && !userSelection.equals("3")) {
                    menuOptions.invalidEntry();
                    menuOptions.pause();
                    userInput.nextLine();
                    menuOptions.accountsViewMenu();
                    userSelection = userInput.nextLine();
                }

                if (userSelection.equals("1")) {                                                                            //LIST ALL ACCOUNTS
                    menuOptions.viewAllAccounts();
                    if (accounts.size() > 0) {
                        for (int i = 0; i < accounts.size(); i++) {
                            int num;
                            System.out.println("(" + (i + 1) + ")  Account Name: " + accounts.get(i).getAccountName() + " | " +
                                    " Account Type: " + accounts.get(i).getAccountType());
                        }
                        System.out.print("Select Account :");
                        int userSelection1 = Integer.parseInt(userInput.nextLine());
                        while (userSelection1 > 0) {
                            System.out.println("------------------------------------------------------------");
                            System.out.println("Account Name: " + accounts.get(userSelection1 - 1).getAccountName() + " | " +
                                    " Account Type: " + accounts.get(userSelection1 - 1).getAccountType());
                            System.out.println("--------------------------------------------------------------");
                            menuOptions.accountMenu();
                            userSelection = userInput.nextLine();
                            if (userSelection.equals("1")) {    //view balance
                                System.out.println("Your current Balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                menuOptions.pause();
                                userSelection = userInput.nextLine();
                            } else if (userSelection.equals("2")) {   //Withdraw
                                System.out.println();
                                System.out.println("Your current balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                System.out.print("How much would you like to Withdraw: ");
                                double withdrawAmount = Double.parseDouble(userInput.nextLine());
                                withdrawFromAccount(withdrawAmount);
                                System.out.println();
                                System.out.println("Amount withdrawn: $" + withdrawAmount);
                                System.out.println("Your Previous Balance was: $" + (accounts.get(userSelection1 - 1).getAccountBalance()));
                                System.out.println("Your Current Balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                menuOptions.pause();
                                userSelection = userInput.nextLine();
                            } else if (userSelection.equals("3")) { //Transfer
                                System.out.println();
                                System.out.println("Your current balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                System.out.print("How much would you like to Transfer: ");
                                double transferAmount = Double.parseDouble(userInput.nextLine());
                                //todo finish transfer methods
                            } else if (userSelection.equals("4")) {   //Deposit
                                System.out.println();
                                System.out.println("Your current balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                System.out.print("How much would you like to Deposit: ");
                                double depositAmount = Double.parseDouble(userInput.nextLine());
                                depositIntoAccount(depositAmount);
                                System.out.println();
                                System.out.println("Amount withdrawn: $" + depositAmount);
                                System.out.println("Your Previous Balance was: $" + (accounts.get(userSelection1 - 1).getAccountBalance()-depositAmount));
                                System.out.println("Your Current Balance is: $" + accounts.get(userSelection1 - 1).getAccountBalance());
                                menuOptions.pause();
                                userSelection = userInput.nextLine();
                            } else break;


                        }
                    } else System.out.println("You don't have any open accounts.");
                    System.out.println();
                    menuOptions.pause();
                    userSelection = userInput.nextLine();
                }else
                if (userSelection.equals("2")) {                                                                       //CREATE A BANK ACCOUNT
                    menuOptions.createAccountMenu();
                    userSelection = userInput.nextLine();
                    if (userSelection.equals("1")) {
                        System.out.print("Please give this account a name: ");
                        String userInputAccountName = userInput.nextLine();
                        System.out.print("Please enter initial deposit: ");
                        Double userInitialDeposit = Double.valueOf(userInput.nextLine());
                        Account checkingAccount = new Account(userInputAccountName, "Checking Account", userInitialDeposit);
                        accounts.add(checkingAccount);
                        System.out.println();
                        System.out.println("Your account has been created.");
                        menuOptions.pause();
                        userInput.nextLine();
                    } else {
                        System.out.print("Please give this account a name: ");
                        String userInputAccountName = userInput.nextLine();
                        System.out.print("Please enter initial deposit: ");
                        Double userInitialDeposit = Double.valueOf(userInput.nextLine());
                        Account savingsAccount = new Account(userInputAccountName, "Savings Account", userInitialDeposit);
                        accounts.add(savingsAccount);
                        System.out.println();
                        System.out.println("Your account has been created.");
                        menuOptions.pause();
                        userInput.nextLine();
                    }
                }

//                else
//                    System.out.println("Thank you for using our system. We'll see you later.");
//                    System.exit(1);


            }
        }
    }
}






