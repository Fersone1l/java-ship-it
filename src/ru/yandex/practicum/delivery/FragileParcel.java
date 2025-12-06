package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    public static final double DELIVERY_COST = 4;

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка %s обёрнута в защитную плёнку%n", description);
        super.packageItem();
    }

    @Override
    public double getDeliveryCost() {
        return DELIVERY_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("Хрупкая посылка %s изменила местоположение на %s%n", description, newLocation);
    }
}
