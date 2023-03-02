package lt.code.academy.task.data;

import lt.code.academy.task.data.Account;

public class User {

    private String id;
    private String name;
    private String surname;
    private String userName;
    private Account account;

    public User() {}

    public User(String id, String name, String surname, String userName, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

