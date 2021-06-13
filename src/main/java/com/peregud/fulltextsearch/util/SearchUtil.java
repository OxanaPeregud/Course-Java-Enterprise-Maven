package com.peregud.fulltextsearch.util;

import com.peregud.fulltextsearch.model.Book;
import lombok.experimental.UtilityClass;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@UtilityClass
public class SearchUtil extends TransactionUtil {

    public void saveData() {
        EntityManager entityManager = HibernateUtil.createEntityManager();

        inTransaction(entityManager, transaction -> {

            Book book = Book.builder()
                    .title("Effective Java")
                    .description("A must-have book for every Java programmer and Java aspirant")
                    .rating(8)
                    .publishingDate(new GregorianCalendar(2005, Calendar.DECEMBER, 5).getTime())
                    .build();
            entityManager.persist(book);

            book = Book.builder()
                    .title("Java: A Beginner’s Guide")
                    .description("It is, in fact, one of the most comprehensive books for learning Java")
                    .rating(10)
                    .publishingDate(new GregorianCalendar(2011, Calendar.MARCH, 13).getTime())
                    .build();
            entityManager.persist(book);

            book = Book.builder()
                    .title("Head First Java")
                    .description("Super-effective real-life analogies that pertain to the Java programming concepts")
                    .rating(5)
                    .publishingDate(new GregorianCalendar(2007, Calendar.APRIL, 7).getTime())
                    .build();
            entityManager.persist(book);
        });
        entityManager.close();
    }

    public void queryOnSingleField() {
        EntityManager entityManager = HibernateUtil.createEntityManager();

        inTransaction(entityManager, transaction -> {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Book.class)
                    .get();

            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.keyword()
                            .onField("title")
                            .matching("java")
                            .createQuery(),
                    Book.class
            );

            List<Book> books = query.getResultList();
            System.out.println(books);
        });

        entityManager.close();
    }

    public void queryOnMultipleFields() {
        EntityManager entityManager = HibernateUtil.createEntityManager();

        inTransaction(entityManager, transaction -> {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Book.class)
                    .get();

            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.keyword()
                            .onFields("title", "description")
                            .matching("java")
                            .createQuery(),
                    Book.class
            );

            List<Book> books = query.getResultList();
            System.out.println(books);
        });

        entityManager.close();
    }

    public void wildcardQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();

        inTransaction(entityManager, transaction -> {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Book.class)
                    .get();

            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.keyword().wildcard()
                            .onFields("title", "description")
                            .matching("program*")
                            .createQuery(),
                    Book.class
            );

            List<Book> books = query.getResultList();
            System.out.println(books);
        });

        entityManager.close();
    }

    public void rangeQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();

        inTransaction(entityManager, transaction -> {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                    .buildQueryBuilder()
                    .forEntity(Book.class)
                    .get();

            FullTextQuery query = fullTextEntityManager.createFullTextQuery(
                    queryBuilder.range()
                            .onField("rating")
                            .from(2)
                            .to(9)
                            .createQuery(),
                    Book.class
            );

            List<Book> books = query.getResultList();
            System.out.println(books);
        });

        entityManager.close();
    }
}
