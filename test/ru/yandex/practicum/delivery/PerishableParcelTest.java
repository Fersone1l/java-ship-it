package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PerishableParcelTest {

    private static PerishableParcel perishableParcel;

    @BeforeAll
    static void beforeAll() {
        perishableParcel = new PerishableParcel("Bananas", 8, "Beijing", 23, 5);
    }

    @Test
    void isNotExpiredOn27Day() {
        Assertions.assertFalse(perishableParcel.isExpired(27));
    }

    @Test
    void isNotExpiredOn28Day() {
        Assertions.assertFalse(perishableParcel.isExpired(28));
    }

    @Test
    void isExpiredOn29Day() {
        Assertions.assertTrue(perishableParcel.isExpired( 29));
    }
}