package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {

    private static PerishableParcel perishableParcel;

    @BeforeAll
    static void beforeAll() {
        perishableParcel = new PerishableParcel("Bananas", 8, "Beijing", (byte) 23, (byte) 5);
    }

    @Test
    void calculateDeliveryCost() {

        Assertions.assertEquals(24, perishableParcel.calculateDeliveryCost());
    }

    @Test
    void isExpiredOn29Day() {
        Assertions.assertTrue(perishableParcel.isExpired((byte) 29));
    }

    @Test
    void isNotExpiredOn28Day() {
        Assertions.assertFalse(perishableParcel.isExpired((byte) 28));
    }

    @Test
    void isExpiredOn30Day() {
        Assertions.assertTrue(perishableParcel.isExpired((byte) 30));
    }

    @Test
    void isNotExpiredOn23Day() {
        Assertions.assertFalse(perishableParcel.isExpired((byte) 23));
    }

    @Test
    void isNotExpiredOn24Day() {
        Assertions.assertFalse(perishableParcel.isExpired((byte) 24));
    }
}