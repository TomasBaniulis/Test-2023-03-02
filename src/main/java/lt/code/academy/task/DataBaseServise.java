package lt.code.academy.task;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.code.academy.task.data.Account;
import lt.code.academy.task.data.User;
import org.bson.types.ObjectId;

public class DataBaseServise {

   private  MongoClient client = MobjectClientProvider.getClient();
    private MongoDatabase db = client.getDatabase("bankUsers");
    private MongoCollection <User> usersCollection = db.getCollection("users", User.class);
    private User user;

    private User receiver;



    User getUser (String userName){
        try{
            user = usersCollection.find(Filters.eq("userName", userName)).first();
        }catch (NullPointerException e){
            System.out.println("no such user");
        }
        return user;
    }

    User getReceiver (String name){
        try {
            receiver = usersCollection.find(Filters.eq("name", name)).first();
        }catch (NullPointerException e){
            System.out.println("no such receiver");
        }
        return receiver;
    }

    void printUserBalance () {
        Account account = user.getAccount();
        double balance = account.getBalance();
        System.out.println("Your account balance:" + balance );
    }

    double getUserBalance (){
        Account account = user.getAccount();
        double balance = account.getBalance();
        return balance;
    }

    double getReceiverBalance (){
        Account account = receiver.getAccount();
        double balance = account.getBalance();
        return balance;
    }


    void makeTransfer (double sum, String receiverName){
        double senderBalance = getUserBalance();
        if (sum < senderBalance) {
            System.out.println("Not enough funds in your account");
            return;
        }
        getReceiver(receiverName);
        double receiverBalance = getUserBalance();

        double senderBalanceUpdate = senderBalance - sum;
        Account userAccount = user.getAccount();
        userAccount.setBalance(senderBalanceUpdate);
        user.setAccount(userAccount);
        usersCollection.updateOne(Filters.eq("_id", new ObjectId(user.getId())), Updates.set("account", userAccount));

        double receiverBalanceUpdate = receiverBalance + sum;
        Account receiverAccount = receiver.getAccount();
        receiverAccount.setBalance(receiverBalanceUpdate);
        receiver.setAccount(receiverAccount);
        usersCollection.updateOne (Filters.eq("_id", new ObjectId(receiver.getId())), Updates.set("account", receiverAccount));

        System.out.println("Your transfer was successful");
    }

    void insertUser ( String name, String surname, String username, Account account){
        User newUser = new User(name, surname,username, account );
        usersCollection.insertOne(user);
        System.out.println("You have successfully registered to the system");
    }




}
