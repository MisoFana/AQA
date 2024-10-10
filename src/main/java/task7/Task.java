package task7;

import org.hibernate.Session;
import org.hibernate.Transaction;
import task6.Parts.HibernateUtil;
import task7.MTM.Project;
import task7.OTM.Department;
import task7.OTM.Employee;
import task7.OTO.UserDetails;
import task7.OTO.UserProfile;

import java.util.List;

public class Task {

    public static void main(String[] args) {
        Task operations = new Task();
        operations.createOneToOne();
        operations.createOneToMany();
        operations.createManyToMany();
        operations.read();
        operations.update();
        operations.delete();
    }

    public void createOneToOne() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        UserProfile profile = new UserProfile();
        profile.setBio("Developer");
        profile.setAvatarUrl("avatar.png");

        UserDetails user = new UserDetails();
        user.setUsername("JohnDoe");
        user.setProfile(profile);

        session.save(user);
        transaction.commit();
        session.close();
    }

    public void createOneToMany() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Department department = new Department();
        department.setName("Engineering");

        Employee emp1 = new Employee();
        emp1.setName("Alice");
        emp1.setDepartment(department);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setDepartment(department);

        department.setEmployees(List.of(emp1, emp2));

        session.save(department);
        transaction.commit();
        session.close();
    }

    public void createManyToMany() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Project project = new Project();
        project.setProjectName("NewProject");

        Employee emp1 = session.get(Employee.class, 1);
        Employee emp2 = session.get(Employee.class, 2);

        project.setEmployees(List.of(emp1, emp2));

        session.save(project);
        transaction.commit();
        session.close();
    }

    public void read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<UserDetails> users = session.createQuery("from UserDetails", UserDetails.class).list();
        for (UserDetails user : users) {
            System.out.println(user.getUsername() + " - " + user.getProfile().getBio());
        }
        session.close();
    }

    public void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        UserDetails user = session.get(UserDetails.class, 1);
        user.setUsername("JaneDoe");
        session.update(user);

        transaction.commit();
        session.close();
    }

    public void delete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        UserDetails user = session.get(UserDetails.class, 1);
        session.delete(user);

        transaction.commit();
        session.close();
    }
}
