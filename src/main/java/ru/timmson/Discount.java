package ru.timmson;

class Discount {

    public static int get(int amount) {
        int discount = 0;
        if (amount >= 1000) {
            if (amount < 5000) {
                discount = 3;
            } else if (amount < 7000) {
                discount = 5;
            }
        }
        return discount;
    }
}
