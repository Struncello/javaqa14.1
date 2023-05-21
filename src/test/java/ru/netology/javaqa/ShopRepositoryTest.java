package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removeIfProductExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "ручка", 100);
        Product product2 = new Product(25, "тетрадь", 200);
        Product product3 = new Product(44, "учебник", 1800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(44);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeIfProductNotExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "ручка", 100);
        Product product2 = new Product(25, "тетрадь", 200);
        Product product3 = new Product(44, "учебник", 1800);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(55)
        );

    }


}
