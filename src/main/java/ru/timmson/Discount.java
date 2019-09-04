package ru.timmson;

class Discount {

    public static int get(int amount) {
        int discount = 0;
        if (amount >= 1000) {
            if (amount < 5000) {
                discount = 3;
            } else {
                discount = 5;
            }
        }
        return discount;
    }

    public static int getAmount(int amount) {
        return Long.valueOf(Math.min(1000, Math.round(amount * get(amount) / 100.0))).intValue();
    }
}
