package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTrackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> boxOfStandardParcels = new ParcelBox<>(10);
    private static ParcelBox<FragileParcel> boxOfFragileParcels = new ParcelBox<>(10);
    private static ParcelBox<PerishableParcel> boxOfPerishableParcels = new ParcelBox<>(10);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = makeChoice(0,5);


            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    checkBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Вывести местоположения всех отслеживаемых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        showParcelTypesMenu();
        int choice = makeChoice(1,3);

        Parcel parcel = makeParcel(choice);
        if (parcel != null) {
            allParcels.add(parcel);
            System.out.println("Посылка успешно добавлена!");
        } else {
            System.out.println("Не удалось создать посылку.");
        }
    }

    private static void showParcelTypesMenu() {
        System.out.println("""
                Выберите тип посылки:
                1 - Стандартная посылка
                2 - Хрупкая посылка
                3 - Скоропортящаяся посылка""");

    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            System.out.println();
        }
    }

    private static void calculateCosts() {
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.printf("Общая стоимость доставок равна %s%n", sum);
    }

    private static void reportStatus(){
        for (Trackable trackable : allTrackableParcels) {
            if (trackable instanceof Parcel parcel) {
                System.out.printf("Введите новое местоположение для посылки %s%n", parcel.description);
            }
            String newLocation = scanner.nextLine();

            trackable.reportStatus(newLocation);
        }
    }

    private static void checkBox() {
        showCheckBoxMenu();
        int choice = makeChoice(1,3);

        switch (choice) {
            case 1:
                showAllFromBox(boxOfStandardParcels, "стандартных посылок");
                break;
            case 2:
                showAllFromBox(boxOfFragileParcels, "хрупких посылок");
                break;
            case 3:
                showAllFromBox(boxOfPerishableParcels, "скоропортящихся посылок");
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }

    private static void showAllFromBox(ParcelBox<? extends Parcel> box, String whichBox){
        System.out.printf("Содержимое коробки %s:%n", whichBox);
        if (box.getAll().isEmpty()) {
            System.out.printf("В коробке %s пока ничего нет.%n", whichBox);
            return;
        }
        for (Parcel parcel : box.getAll()) {
            System.out.printf("\tПосылка %s%n", parcel.description);
        }
    }

    private static void showCheckBoxMenu() {
        System.out.println("""
                Выберите тип коробки:
                1 - Коробка стандартных посылок
                2 - Коробка хрупких посылок
                3 - Коробка скоропортящихся посылок""");
    }

    private static int nextLineToInt() {
        String string = scanner.nextLine();
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double nextLineToDouble() {
        String string = scanner.nextLine();
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static byte nextLineToByteDay() {
        while (true) try {
            String string = scanner.nextLine();
            byte day = Byte.parseByte(string);
            if (day > 0) {
                return day;
            } else {
                System.out.println("Число должно быть больше 0. Введите снова: ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректное число, введите другое: ");
        }
    }

    private static Parcel makeParcel(int choice) {
        System.out.println("Введите описание посылки: ");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки: ");
        double weight = nextLineToDouble();
        while (weight <= 0) {
            System.out.println("Некорректное значение веса, введите вес еще раз: ");
            weight = nextLineToDouble();
        }

        System.out.println("Введите адрес доставки: ");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки: ");
        byte sendDay = nextLineToByteDay();
        while (sendDay <= 0 || sendDay > 31) {
            System.out.println("День отправки должен находится в пределах от 1 до 31, введите день еще раз: ");
            sendDay = nextLineToByteDay();
        }

        switch (choice) {
            case 1 :
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                boxOfStandardParcels.addParcel(standardParcel);
                return standardParcel;
            case 2 :
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allTrackableParcels.add(fragileParcel);
                boxOfFragileParcels.addParcel(fragileParcel);
                return fragileParcel;
            case 3 :
                System.out.println("Введите срок годности: ");
                byte timeToLive = nextLineToByteDay();
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                boxOfPerishableParcels.addParcel(perishableParcel);
                return perishableParcel;
            default:
                System.out.println("Неверный выбор.");
                return null;
        }
    }

    private static int makeChoice(int minNumberOfChoice, int amountOfPoints) {
        int choice = nextLineToInt();
        while(choice < minNumberOfChoice || choice > amountOfPoints) {
            System.out.println("Неверный выбор. Попробуйте снова:");
            choice = nextLineToInt();
        }
        return choice;
    }
}
