package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    final double maxWeight;
    ArrayList<T> parcels = new ArrayList<>();
    double weight = 0;

    public ParcelBox(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        double additionWeight = parcel.getWeight();
        String additionParcel = parcel.getDescription();

        if (weight + additionWeight > maxWeight) {
            System.out.printf("В коробке нет места для посылки %s%n", additionParcel);
            return;
        }
        parcels.add(parcel);
        weight += additionWeight;
        System.out.printf("Посылка %s успешно добавлена в коробку!%n", additionParcel);
    }

    public ArrayList<T> getAll() {
        return parcels;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public ArrayList<T> getParcels() {
        return parcels;
    }

    public double getWeight() {
        return weight;
    }
}
