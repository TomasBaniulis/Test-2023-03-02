package lt.code.academy.task;

public class Account {

    private String id;
    private String accountNumber;
    private String bankName;
    private double balance;

    public Account() {}

    public Account(String id, String accountNumber, String bankName, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
