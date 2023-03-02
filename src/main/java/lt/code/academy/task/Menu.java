package lt.code.academy.task;

import lt.code.academy.task.data.Account;
import lt.code.academy.task.data.User;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    DataBaseServise dbServise = new DataBaseServise();

    void showLoginMenu (){
        System.out.println("""
                1. log in 
                2. create user
                3. exit 
                """);

    }

    void loginMenu (){
        String action;
        do {
            showLoginMenu();
             action = scanner.nextLine();
             loginMenuAction(action);
        }while (!action.equals("3"));
    }

    void loginMenuAction (String action){
        switch (action){
            case "1" -> logUser();
            case "2" -> userRegistration();
            case "3" -> System.out.println("exit");
            default -> System.out.println("no such action");
        }
    }

    private void  logUser (){
        System.out.println("Enter your userName");
        String userName = scanner.nextLine();
        User user = dbServise.getUser(userName);
        userMenu();
    }

    void printUserMenu (){
        System.out.println("""
                1. your account balance"
                2. make transfer
                3. exit
                """);
    }

    void userMenu (){
        String action;
        do {
            showLoginMenu();
            action = scanner.nextLine();
            userMenuAction(action);
        }while (!action.equals("3"));
    }

    private void userMenuAction (String action){
        switch (action) {
            case "1" -> dbServise.printUserBalance();
            case "2" -> makeUserTransfer();
            case "3" -> System.out.println("exit");
            default -> System.out.println("no such action");
        }
    }

    private void makeUserTransfer (){
        System.out.println("Enter sum you want to transfer");
        double sum = scanner.nextDouble();
        System.out.println("enter receiver name");
        String receiverName = scanner.nextLine();
        dbServise.makeTransfer(sum, receiverName);
    }

    private void userRegistration (){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("enter your surname");
        String surname = scanner.nextLine();
        System.out.println("enter your username");
        String username = scanner.nextLine();
        System.out.println("enter your account id");
        String id = scanner.nextLine();
        System.out.println("enter account number");
        String accountNumber = scanner.nextLine();
        System.out.println("enter bank name");
        String bank = scanner.nextLine();
        System.out.println("enter your balance");
        Double balance = Double.parseDouble(scanner.nextLine());
        Account account = new Account(id, accountNumber, bank, balance);
        dbServise.insertUser(name, surname, username, account);
    }

}
