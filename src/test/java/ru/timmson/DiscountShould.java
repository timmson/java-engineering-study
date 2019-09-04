package ru.timmson;

import io.cucumber.java.ru.*;

import static org.junit.Assert.assertEquals;

public class DiscountShould {

    private int amount;
    private int actualResult;
    private boolean isPrivate = false;

    @Дано("Сумма покупки {int}")
    public void givenAmount(int amount) {
        this.amount = amount;
    }

    @Дано("Сумма покупки {int} и покупатель {string}")
    public void givenAmountAndBuyerStatus(int amount, String status) {
        this.isPrivate = status.equals("особый");
        this.amount = amount;
    }

    @Когда("Считаем сидку")
    public void whenGetDiscount() {
        this.actualResult = Discount.get(this.amount);
    }

    @Когда("Считаем сумму скидки")
    public void whenGetDiscountAmount() {
        this.actualResult = Discount.getAmount(this.amount, this.isPrivate);
    }

    @Тогда("Получаем скидку {int}%")
    public void thenDiscount(int expectedResult) {
        assertEquals(expectedResult, actualResult);
    }

    @Тогда("Получаем скидку {int}")
    public void thenDiscountAmount(int expectedResult) {
        assertEquals(expectedResult, actualResult);
    }

}
