package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParcelBoxTest {
    private static ParcelBox<PerishableParcel> boxOfPerishableParcels;
    private static PerishableParcel perishableParcel9;
    private static PerishableParcel perishableParcel10;
    private static PerishableParcel perishableParcel11;

    @BeforeEach
    void beforeEach() {
        boxOfPerishableParcels = new ParcelBox<>(10);
    }

    @Test
    void addWeight9ToParcelWithMaxWeight10() {
        perishableParcel9 = new PerishableParcel("Bananas", 9, "Beijing", 23, 5);

        boxOfPerishableParcels.addParcel(perishableParcel9);
        Assertions.assertEquals(1, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight10ToParcelWithMaxWeight10() {
        perishableParcel10 = new PerishableParcel("Bananas", 10, "Beijing", 23, 5);

        boxOfPerishableParcels.addParcel(perishableParcel10);
        Assertions.assertEquals(1, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight11ToParcelWithMaxWeight10() {
        perishableParcel11 = new PerishableParcel("Bananas", 11, "Beijing", 23, 5);

        boxOfPerishableParcels.addParcel(perishableParcel11);
        Assertions.assertEquals(0, boxOfPerishableParcels.getAll().size());
    }
}