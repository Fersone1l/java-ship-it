package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

public class DeliveryCostTest {
    @Test
    void calculateDeliveryCostForStandardParcelParcelWithWeight3() {
        StandardParcel standardParcel3 = new StandardParcel("Books", 3, "Moscow", 3);

        Assertions.assertEquals(6, standardParcel3.calculateDeliveryCost());
    }
    @Test
    void calculateDeliveryCostForStandardParcelWithWeight0() {
        StandardParcel standardParcel0 = new StandardParcel("Books", 0, "Moscow", 3);

        Assertions.assertEquals(0, standardParcel0.calculateDeliveryCost());
    }

    @Test
    void calculateDeliveryCostForFragileParcelWithWeight2() {
        FragileParcel fragileParcel = new FragileParcel("Monitor", 2, "London", 15);

        Assertions.assertEquals(8, fragileParcel.calculateDeliveryCost());
    }

    @Test
    void calculateDeliveryCostForFragileParcelWithWeight0() {
        FragileParcel fragileParcel = new FragileParcel("Monitor", 0, "London", 15);

        Assertions.assertEquals(0, fragileParcel.calculateDeliveryCost());
    }

    @Test
    void calculateDeliveryCostForPerishableParcelWithWeight8() {
        PerishableParcel perishableParcel = new PerishableParcel("Bananas", 8, "Beijing", 23, 5);

        Assertions.assertEquals(24, perishableParcel.calculateDeliveryCost());
    }

    @Test
    void calculateDeliveryCostForPerishableParcelWithWeight0() {
        PerishableParcel perishableParcel = new PerishableParcel("Bananas", 0, "Beijing", 23, 5);

        Assertions.assertEquals(0, perishableParcel.calculateDeliveryCost());
    }
}
