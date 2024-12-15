package test;

import main.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataGeneratorTest {

    public static void generateTestData(Session session) {
        Transaction tx = session.beginTransaction();

        User user1 = new User("shun228123@gmail.com", "123123123");

        session.save(user1);

        tx.commit();
    }
}

