package lt.code.academy.task;

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
        }while (!action.equals("3"));
    }

    void loginMenuAction (String action){
        switch (action){
            case "1" -> logUser();
            case "2" -> System.out.println("please register") ;
            case "3" -> System.out.println("exit");
            default -> System.out.println("no such action");
        }
    }

    private void  logUser (){
        System.out.println("Enter your userName");
        String userName = scanner.nextLine();
        User user = dbServise.getUser(userName);

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
        }while (!action.equals("3"));
    }

    private void userMenuAction (String action){
        switch (action) {
            case "1" -> dbServise.getUserBalance();
            case "2" -> System.out.println("transfer money");
            case "3" -> System.out.println("exit");
            default -> System.out.println("no such action");
        }
    }






}
