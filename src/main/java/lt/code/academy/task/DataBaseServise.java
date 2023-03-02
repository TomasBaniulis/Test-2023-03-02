package lt.code.academy.task;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class DataBaseServise {

   private  MongoClient client = MobjectClientProvider.getClient();
    private MongoDatabase db = client.getDatabase("bankUsers");
    private MongoCollection <User> usersCollection = db.getCollection("users", User.class);
    private User user;


    User getUser (String userName){
      return user = usersCollection.find(Filters.eq("userName", userName)).first();
    }

    void getUserBalance () {
        Account account = user.getAccount();
        double balance = account.getBalance();
        System.out.println("Your account balance:" + balance );
    }



}
