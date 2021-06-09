package com.peregud.jpqlqueries.util;

import com.peregud.jpqlqueries.model.Salesperson;
import com.peregud.jpqlqueries.model.Store;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

@UtilityClass
public class DataGeneratorUtil {
    private final List<String> STORE_NAMES;
    private final List<String> ADDRESSES;
    private final List<String> FIRST_NAMES;
    private final List<String> LAST_NAMES;
    private final List<LocalDate> DATE;
    private final Random RANDOM = new Random();

    static {
        STORE_NAMES = Arrays.asList("Магазин № 1", "Магазин № 2", "Магазин № 3");
        ADDRESSES = Arrays.asList("Адрес № 1", "Адрес № 2", "Адрес № 3");
        FIRST_NAMES = Arrays.asList("Иван", "Петр");
        LAST_NAMES = Arrays.asList("Иванов", "Петров", "Сидоров", "Белов", "Романов");
        DATE = Arrays.asList(
                LocalDate.of(2010, 5, 11),
                LocalDate.of(2005, 1, 7),
                LocalDate.of(2017, 8, 3));
    }

    public void generateDataForDB() {
        Store store1 = Store.builder()
                .name(STORE_NAMES.get(RANDOM.nextInt(STORE_NAMES.size())))
                .address(ADDRESSES.get(RANDOM.nextInt(ADDRESSES.size())))
                .registrationDate(DATE.get(RANDOM.nextInt(DATE.size())))
                .revenue(roundUp((Math.random() * (15000 - 1000)) + 1000))
                .build();
        Salesperson salesperson1 = Salesperson.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .salary(roundUp((Math.random() * (5000 - 1500)) + 1500))
                .store(store1)
                .build();
        Salesperson salesperson2 = Salesperson.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .salary(roundUp((Math.random() * (5000 - 1500)) + 1500))
                .store(store1)
                .build();
        Set<Salesperson> salespeople1 = new HashSet<>();
        salespeople1.add(salesperson1);
        salespeople1.add(salesperson2);
        store1.setSalespeople(salespeople1);

        Store store2 = Store.builder()
                .name(STORE_NAMES.get(RANDOM.nextInt(STORE_NAMES.size())))
                .address(ADDRESSES.get(RANDOM.nextInt(ADDRESSES.size())))
                .registrationDate(DATE.get(RANDOM.nextInt(DATE.size())))
                .revenue(roundUp((Math.random() * (15000 - 1000)) + 1000))
                .build();
        Salesperson salesperson3 = Salesperson.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .salary(roundUp((Math.random() * (5000 - 1500)) + 1500))
                .store(store2)
                .build();
        Set<Salesperson> salespeople2 = new HashSet<>();
        salespeople2.add(salesperson3);
        store2.setSalespeople(salespeople2);

        Store store3 = Store.builder()
                .name(STORE_NAMES.get(RANDOM.nextInt(STORE_NAMES.size())))
                .address(ADDRESSES.get(RANDOM.nextInt(ADDRESSES.size())))
                .registrationDate(DATE.get(RANDOM.nextInt(DATE.size())))
                .revenue(roundUp((Math.random() * (2000 - 200)) + 200))
                .build();
        Salesperson salesperson4 = Salesperson.builder()
                .firstName(FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size())))
                .lastName(LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size())))
                .salary(roundUp((Math.random() * (5000 - 1500)) + 1500))
                .store(store3)
                .build();
        Set<Salesperson> salespeople3 = new HashSet<>();
        salespeople3.add(salesperson4);
        store3.setSalespeople(salespeople3);
        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(store1);
        entityManager.persist(store2);
        entityManager.persist(store3);
        entityManager.persist(salesperson1);
        entityManager.persist(salesperson2);
        entityManager.persist(salesperson3);
        entityManager.persist(salesperson4);
        entityManager.getTransaction().commit();
    }

    public double roundUp(double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
