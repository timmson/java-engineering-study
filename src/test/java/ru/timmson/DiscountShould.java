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
    public void when() {
        this.actualResult = Discount.get(this.amount);
    }

    @Тогда("Получаем скидку {int}")
    public void then(int expectedResult) {
        assertEquals(expectedResult, actualResult);
    }

}
