package cs544.imp1.problemB.controllers;


import cs544.imp1.problemB.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 2:05
 */

public class Store {
    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


    public static void main(String[] args) throws Exception {
        setUp();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Order order = new Order();


            Product dvd = new Dvd("DVd 4 fantastic");
            dvd.setDescription("the number one to clean your toohs");

            Product cd = new Cd("Madona ");
            cd.setDescription("Music");

            Product book = new Book("Fourth Agrements ");
            cd.setDescription("books");


            order.addLine(new OrderLine(1, dvd));
            order.addLine(new OrderLine(2, cd));
            order.addLine(new OrderLine(3, book));


            Customer pedro = new Customer();

            pedro.setFirtsName("Pedro");
            pedro.setLastName("Mosquera");
            pedro.addOrder(order);


            session.persist(pedro);

            session.getTransaction().commit();
        }

        tearDown();
    }
}
