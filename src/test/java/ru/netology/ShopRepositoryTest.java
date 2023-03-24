package ru.netology;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(789, "Suit", 5_000);
    Product product2 = new Product(1456, "Cup", 375);
    Product product3 = new Product(1789554, "Book", 1_200);
    ShopRepository shopRepository = new ShopRepository();

    @Test
    public void shouldRemoveExistId() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.removeById(789);
        Product[] expected = new Product[]{product2, product3};
        Product[] actual = shopRepository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnExceptionWhenWantRemoveNotExistId() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {

            shopRepository.removeById(2);
        });
    }


}
