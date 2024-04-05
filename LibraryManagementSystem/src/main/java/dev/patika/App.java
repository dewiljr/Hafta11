package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();
        //Category Add
        Category category = new Category();
        category.setDescription("Bla Bla Bla");
        category.setName("Kurgu");


        entityManager.persist(category);

        //Publisher Add
        Publisher publisher = new Publisher();
        publisher.setAddress("Çankaya / Ankara");
        publisher.setName("Ankara Yayınevi");
        publisher.setEstablishmentYear(LocalDate.of(1992, 12, 2));

        entityManager.persist(publisher);

        //Author Add
        Author author = new Author();
        author.setCountry("Ankara");
        author.setName("Adnan");
        author.setBirthDate(LocalDate.of(1980, 12, 12));
        entityManager.persist(author);

        //Book Add
        Book book = new Book();
        book.setName("Portakal");
        book.setStock(10);
        book.setPubYear(LocalDate.of(2022, 12, 12));
        book.setAuthor(author);
        book.setPublisher(publisher);

        entityManager.persist(book);
        //Borrower Add
        Borrower borrower = new Borrower();
        borrower.setBorrower_date(LocalDate.of(2023, 12, 12));
        borrower.setReturn_date(LocalDate.of(2023, 12, 15));
        borrower.setName("Havalar");
        borrower.setBook(book);
        entityManager.persist(borrower);

        transaction.commit();


        /* DATABASE DELETE
        transaction.begin();
        Book book = entityManager.find(Book.class,4);


        entityManager.remove(book);
        transaction.commit();

        */


    }
}
