package com.peregud.iteratorcompositepattern.util;

import com.peregud.iteratorcompositepattern.Iterator;
import com.peregud.iteratorcompositepattern.ProductItem;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PrintProductsUtil {

    public void printProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            ProductItem productItem = (ProductItem) iterator.next();
            System.out.print(productItem.getId() + ": ");
            System.out.print(productItem.getName() + ", ");
            System.out.println(productItem.getPrice());
        }
    }
}
