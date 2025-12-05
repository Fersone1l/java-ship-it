package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FragileParcelTest {

    @Test
    void calculateDeliveryCost() {
        FragileParcel fragileParcel = new FragileParcel("Monitor", 2, "London", (byte) 15);

        Assertions.assertEquals(8, fragileParcel.calculateDeliveryCost());
    }
}