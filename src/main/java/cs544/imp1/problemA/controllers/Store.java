package cs544.imp1.problemA.controllers;

import cs544.imp1.problemA.models.Customer;
import cs544.imp1.problemA.models.Order;
import cs544.imp1.problemA.models.OrderLine;
import cs544.imp1.problemA.models.Product;
import org.hibernate.SessionFactory;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 2:05
 */

import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
        if (sessionFactory != null)
        {
            sessionFactory.close();
        }
    }


    public static void main(String[] args) throws Exception {
        setUp();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Order order = new Order();





            for (int index = 1; index < 10; index++) {
                Product creamColgate = new Product();
                creamColgate.setName(String.format("Cream Colgate %s",index) );
                creamColgate.setDescription("the number one to clean your toohs");
                OrderLine line_1=new OrderLine();

                line_1.setProduct(creamColgate);
                line_1.setQuantity(index);
                order.addLine(line_1);
            }



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
