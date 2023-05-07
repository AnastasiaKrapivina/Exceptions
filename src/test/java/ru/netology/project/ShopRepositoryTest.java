package ru.netology.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    Product product1 = new Product(11, "хлеб", 41);
    Product product2 = new Product(22, "молоко", 75);
    Product product3 = new Product(3, "сметана", 90);

    @Test
    public void testAdd() {
        ShopRepository rep = new ShopRepository();
        rep.add(product1, 11);
        rep.add(product2, 22);
        rep.add(product3, 3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = rep.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testAddMatchedID() {
        ShopRepository rep = new ShopRepository();
        Product product4 = new Product(3, "рис", 70);
        rep.add(product1, 11);
        rep.add(product2, 22);
        rep.add(product3, 3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            rep.add(product4, 3);
        });
    }
    @Test
    public void removeAnExistingElement() {
        ShopRepository rep = new ShopRepository();
        rep.add(product1, 11);
        rep.add(product2, 22);
        rep.add(product3, 3);
        rep.removeById(11);

        Product[] expected = {product2, product3};
        Product[] actual = rep.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeANonExistingElement() {
        ShopRepository rep = new ShopRepository();
        rep.add(product1, 11);
        rep.add(product2, 22);
        rep.add(product3, 3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            rep.removeById(10);
        });
    }

}