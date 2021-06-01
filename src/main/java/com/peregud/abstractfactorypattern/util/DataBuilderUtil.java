package com.peregud.abstractfactorypattern.util;

import com.peregud.abstractfactorypattern.model.CarEntity;
import com.peregud.abstractfactorypattern.model.CarModel;
import com.peregud.abstractfactorypattern.model.MotorcycleEntity;
import com.peregud.abstractfactorypattern.model.MotorcycleModel;
import lombok.experimental.UtilityClass;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class DataBuilderUtil {

    public void generateDataForDB() {
        CarEntity carEntity1 = CarEntity.builder()
                .carBrand("Porsche")
                .build();
        CarModel carModel1 = CarModel.builder()
                .carModel("Carrera")
                .price(90000)
                .carEntity(carEntity1)
                .build();
        CarModel carModel2 = CarModel.builder()
                .carModel("Panamera")
                .price(130000)
                .carEntity(carEntity1)
                .build();
        Set<CarModel> carModels1 = new HashSet<>();
        carModels1.add(carModel1);
        carModels1.add(carModel2);
        carEntity1.setCarModels(carModels1);

        CarEntity carEntity2 = CarEntity.builder()
                .carBrand("Mazda")
                .build();
        CarModel carModel3 = CarModel.builder()
                .carModel("CX-5")
                .price(35000)
                .carEntity(carEntity2)
                .build();
        Set<CarModel> carModels2 = new HashSet<>();
        carModels2.add(carModel3);
        carEntity2.setCarModels(carModels2);

        CarEntity carEntity3 = CarEntity.builder()
                .carBrand("Audi")
                .build();
        CarModel carModel4 = CarModel.builder()
                .carModel("A7")
                .price(65000)
                .carEntity(carEntity3)
                .build();
        Set<CarModel> carModels3 = new HashSet<>();
        carModels3.add(carModel4);
        carEntity3.setCarModels(carModels3);


        MotorcycleEntity motorcycleEntity1 = MotorcycleEntity.builder()
                .motorcycleBrand("Kawasaki")
                .build();
        MotorcycleModel motorcycleModel1 = MotorcycleModel.builder()
                .motorcycleModel("Ninja")
                .price(5000)
                .motorcycleEntity(motorcycleEntity1)
                .build();
        MotorcycleModel motorcycleModel2 = MotorcycleModel.builder()
                .motorcycleModel("Vulcan")
                .price(7000)
                .motorcycleEntity(motorcycleEntity1)
                .build();
        Set<MotorcycleModel> motorcycleModels1 = new HashSet<>();
        motorcycleModels1.add(motorcycleModel1);
        motorcycleModels1.add(motorcycleModel2);
        motorcycleEntity1.setMotorcycleModels(motorcycleModels1);

        MotorcycleEntity motorcycleEntity2 = MotorcycleEntity.builder()
                .motorcycleBrand("Suzuki")
                .build();
        MotorcycleModel motorcycleModel3 = MotorcycleModel.builder()
                .motorcycleModel("Gixxer")
                .price(6500)
                .motorcycleEntity(motorcycleEntity2)
                .build();
        Set<MotorcycleModel> motorcycleModels2 = new HashSet<>();
        motorcycleModels2.add(motorcycleModel3);
        motorcycleEntity2.setMotorcycleModels(motorcycleModels2);

        MotorcycleEntity motorcycleEntity3 = MotorcycleEntity.builder()
                .motorcycleBrand("Yamaha")
                .build();
        MotorcycleModel motorcycleModel4 = MotorcycleModel.builder()
                .motorcycleModel("YZF")
                .price(17000)
                .motorcycleEntity(motorcycleEntity3)
                .build();
        Set<MotorcycleModel> motorcycleModels3 = new HashSet<>();
        motorcycleModels3.add(motorcycleModel4);
        motorcycleEntity3.setMotorcycleModels(motorcycleModels3);


        EntityManager entityManager = HibernateUtil.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(carModel1);
        entityManager.persist(carModel2);
        entityManager.persist(carModel3);
        entityManager.persist(carModel4);
        entityManager.persist(motorcycleModel1);
        entityManager.persist(motorcycleModel2);
        entityManager.persist(motorcycleModel3);
        entityManager.persist(motorcycleModel4);
        entityManager.getTransaction().commit();
        HibernateUtil.close();
    }
}
