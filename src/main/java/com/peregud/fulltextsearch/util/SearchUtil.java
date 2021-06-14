package com.peregud.fulltextsearch.util;

import com.peregud.fulltextsearch.model.Book;
import com.peregud.fulltextsearch.model.BookTrans;
import lombok.experimental.UtilityClass;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.BasicTransformerAdapter;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
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
                    .publishingDate(LocalDate.of(2005, 12, 5))
                    .build();
            entityManager.persist(book);

            book = Book.builder()
                    .title("Java: A Beginner’s Guide")
                    .description("It is, in fact, one of the most comprehensive books for learning Java")
                    .rating(10)
                    .publishingDate(LocalDate.of(2011, 3, 13))
                    .build();
            entityManager.persist(book);

            book = Book.builder()
                    .title("Head First Java")
                    .description("Super-effective real-life analogies that pertain to the Java programming concepts")
                    .rating(5)
                    .publishingDate(LocalDate.of(2007, 4, 7))
                    .build();
            entityManager.persist(book);
        });
        entityManager.close();
    }

    public List<?> queryOnSingleField() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> books = new ArrayList<>();

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

            books.add(query.getResultList());
        });

        entityManager.close();
        return books;
    }

    public List<?> queryOnMultipleFields() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> books = new ArrayList<>();

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

            books.add(query.getResultList());
        });

        entityManager.close();
        return books;
    }

    public List<?> wildcardQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> books = new ArrayList<>();

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

            books.add(query.getResultList());
        });

        entityManager.close();
        return books;
    }

    public List<?> rangeQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> books = new ArrayList<>();

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

            books.add(query.getResultList());
        });

        entityManager.close();
        return books;
    }

    public List<?> projectionWithTransformer() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        List<List<?>> projection = new ArrayList<>();

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
            )
                    .setProjection("title", "publishing_date")
                    .setResultTransformer(new BasicTransformerAdapter() {
                        @Override
                        public BookTrans transformTuple(Object[] tuple, String[] aliases) {
                            return new BookTrans((String) tuple[0], (LocalDate) tuple[1]);
                        }
                    });

            projection.add(query.getResultList());
        });

        entityManager.close();
        return projection;
    }
}
