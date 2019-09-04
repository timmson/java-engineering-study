# language: ru

Функция: Скидка в магазине

  Структура сценария: Если сумма покупки <сумма покупки>, то скидка <скидка>%. Но скидка не может быть больше 1000
    Дано Сумма покупки <сумма покупки>
    Когда Считаем сидку
    Тогда Получаем скидку <скидка>%

    Примеры:
      | сумма покупки | скидка |
      | 1             | 0      |
      | 999           | 0      |
      | 1000          | 3      |
      | 4999          | 3      |
      | 5000          | 5      |
      | 6999          | 5      |

  Структура сценария: Если сумма покупки <сумма покупки>, то скидка <скидка>. Но не более 1000 для покупателей со статусом "обычный"
    Дано Сумма покупки <сумма покупки> и покупатель <статус покупателя>
    Когда Считаем сумму скидки
    Тогда Получаем скидку <скидка>

    Примеры:
      | сумма покупки | статус покупателя | скидка |
      | 1             | "обычный"         | 0      |
      | 999           | "обычный"         | 0      |
      | 1000          | "обычный"         | 30     |
      | 4999          | "обычный"         | 150    |
      | 5000          | "обычный"         | 250    |
      | 6999          | "обычный"         | 350    |
      | 19999         | "обычный"         | 1000   |
      | 20000         | "обычный"         | 1000   |
      | 20020         | "обычный"         | 1000   |
      | 20020         | "особый"          | 1001   |