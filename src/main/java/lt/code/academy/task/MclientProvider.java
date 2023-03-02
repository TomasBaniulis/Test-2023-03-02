package lt.code.academy.task;

import com.mongodb.MongoClient;


public class MclientProvider {

    private static MongoClient client;

    public MclientProvider() {
    };

    public static com.mongodb.MongoClient getClient() {
        if (client == null) {
            client = new com.mongodb.MongoClient();
        }
        return client;
    }
}