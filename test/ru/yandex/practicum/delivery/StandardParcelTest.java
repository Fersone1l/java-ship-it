package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardParcelTest {

    @Test
    void calculateDeliveryCost() {
        StandardParcel standardParcel = new StandardParcel("Books", 3, "Moscow", (byte) 3);

        Assertions.assertEquals(6, standardParcel.calculateDeliveryCost());

    }
}