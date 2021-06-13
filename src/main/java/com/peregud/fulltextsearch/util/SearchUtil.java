package com.peregud.fulltextsearch.util;

import com.peregud.fulltextsearch.model.Book;
import com.peregud.fulltextsearch.model.BookTrans;
import lombok.experimental.UtilityClass;
import org.hibernate.search.elasticsearch.ElasticsearchProjectionConstants;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.transform.BasicTransformerAdapter;

import javax.persistence.EntityManager;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

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

    public List<?> queryOnSingleField() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        final List<?>[] books = {new ArrayList<>()};

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

            books[0] = query.getResultList();
        });

        entityManager.close();
        return books[0];
    }

    public List<?> queryOnMultipleFields() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        final List<?>[] books = {new ArrayList<>()};

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

            books[0] = query.getResultList();
        });

        entityManager.close();
        return books[0];
    }

    public List<?> wildcardQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        final List<?>[] books = {new ArrayList<>()};

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

            books[0] = query.getResultList();
        });

        entityManager.close();
        return books[0];
    }

    public List<?> rangeQuery() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        final List<?>[] books = {new ArrayList<>()};

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

            books[0] = query.getResultList();
        });

        entityManager.close();
        return books[0];
    }

    public List<?> projectionWithTransformer() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        final List<?>[] projection = {new ArrayList<>()};

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
                            return new BookTrans((String) tuple[0], (Date) tuple[1]);
                        }
                    });

            projection[0] = query.getResultList();
        });

        entityManager.close();
        return projection[0];
    }

    @SuppressWarnings("unchecked")
    public AtomicReference<Book> projection() {
        EntityManager entityManager = HibernateUtil.createEntityManager();
        AtomicReference<Book> books = new AtomicReference<>(new Book());

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
                    .setProjection(ElasticsearchProjectionConstants.THIS);

            List<Object[]> projection = query.getResultList();
            projection.forEach(book -> books.set((Book) book[0]));
        });

        entityManager.close();
        return books;
    }
}
