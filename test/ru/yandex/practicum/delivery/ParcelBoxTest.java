package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {
    private static ParcelBox<PerishableParcel> boxOfPerishableParcels;
    private static PerishableParcel perishableParcel1;
    private static PerishableParcel perishableParcel11;
    private static PerishableParcel perishableParcel12;
    private static PerishableParcel perishableParcel13;

    @BeforeEach
    void beforeEach() {
        boxOfPerishableParcels = new ParcelBox<>(12);
        perishableParcel1 = new PerishableParcel("Bananas", 1, "Beijing", (byte) 23, (byte) 5);
        perishableParcel11 = new PerishableParcel("Bananas", 11, "Beijing", (byte) 23, (byte) 5);
        perishableParcel12 = new PerishableParcel("Bananas", 12, "Beijing", (byte) 23, (byte) 5);
        perishableParcel13 = new PerishableParcel("Bananas", 13, "Beijing", (byte) 23, (byte) 5);
    }

    @Test
    void addWeight1ToParcel() {
        boxOfPerishableParcels.addParcel(perishableParcel1);
        Assertions.assertEquals(1, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight11ToParcel() {
        boxOfPerishableParcels.addParcel(perishableParcel11);
        Assertions.assertEquals(1, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight12ToParcel() {
        boxOfPerishableParcels.addParcel(perishableParcel12);
        Assertions.assertEquals(1, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight13ToParcel() {
        boxOfPerishableParcels.addParcel(perishableParcel13);
        Assertions.assertEquals(0, boxOfPerishableParcels.getAll().size());
    }

    @Test
    void addWeight1And11ToParcel() {
        boxOfPerishableParcels.addParcel(perishableParcel1);
        boxOfPerishableParcels.addParcel(perishableParcel11);
        Assertions.assertEquals(2, boxOfPerishableParcels.getAll().size());
    }
}