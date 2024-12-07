package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        // Load configuration and create session factory
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Add some clients
        insertClient(sessionFactory, new Client("John Doe", "Male", 30, "New York", "john@example.com", "1234567890"));
        insertClient(sessionFactory, new Client("Jane Smith", "Female", 28, "London", "jane@example.com", "0987654321"));

        // Print all client records with all properties
        printAllClients(sessionFactory);

        // Print all client records with selected properties (name and email)
        printSelectedClientDetails(sessionFactory);

        sessionFactory.close();
    }

    // Insert Client record
    public static void insertClient(SessionFactory sessionFactory, Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);  // Insert record
        transaction.commit();
        session.close();
        System.out.println("Inserted: " + client);
    }

    // Print all clients with all properties using HQL
    public static void printAllClients(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("FROM Client", Client.class).list();
        for (Client client : clients) {
            System.out.println(client);
        }
        session.close();
    }

    // Print selected properties (name, email) using HQL
    public static void printSelectedClientDetails(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Object[]> clients = session.createQuery("SELECT name, email FROM Client", Object[].class).list();
        for (Object[] clientData : clients) {
            System.out.println("Name: " + clientData[0] + ", Email: " + clientData[1]);
        }
        session.close();
    }
}
