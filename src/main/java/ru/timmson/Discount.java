package ru.timmson;

class Discount {

    public static int get(int amount) {
        return (amount < 1000) ? 0 : 3;
    }
}
