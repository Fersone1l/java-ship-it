package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    protected final int timeToLive;
    public static final double DELIVERY_COST = 3;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

    @Override
    public double getDeliveryCost() {
        return DELIVERY_COST;
    }

    public int getTimeToLive() {
        return timeToLive;
    }
}
