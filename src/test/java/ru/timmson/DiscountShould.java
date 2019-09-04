package ru.timmson;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.junit.Assert.assertEquals;

public class DiscountShould {

    private int amount;
    private int actualResult;

    @Дано("Сумма покупки {int}")
    public void given(int amount) {
        this.amount = amount;
    }

    @Когда("Считаем сидку")
    public void whenGetDiscount() {
        this.actualResult = Discount.get(this.amount);
    }

    @Когда("Считаем сидку в валюте покупке")
    public void whenGetDiscountAmount() {
        this.actualResult = Discount.getAmount(this.amount);
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
