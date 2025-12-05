package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    public static final double deliveryCost = 2;

    public StandardParcel(String description, double weight, String deliveryAddress, byte sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double calculateDeliveryCost() {
        return super.calculateDeliveryCost();
    }

    @Override
    public double getDeliveryCost() {
        return deliveryCost;
    }
}
