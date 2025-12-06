package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected final String description;
    protected final double weight;
    protected final String deliveryAddress;
    protected final int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.printf("Посылка %s упакована%n", description);
    }

    public void deliver() {
        System.out.printf("Посылка %s доставлена по адресу %s%n", description, deliveryAddress);
    }

    public double calculateDeliveryCost() {
        return weight * getDeliveryCost();
    }

    public abstract double getDeliveryCost();

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }
}
