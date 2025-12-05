package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    protected final byte timeToLive;
    public static final double deliveryCost = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, byte sendDay, byte timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double calculateDeliveryCost() {
        return super.calculateDeliveryCost();
    }

    public boolean isExpired(byte currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

    @Override
    public double getDeliveryCost() {
        return deliveryCost;
    }
}
