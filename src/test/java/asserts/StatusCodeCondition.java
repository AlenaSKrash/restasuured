package asserts;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
/**
 * Реализация интерфейа Condition для универсального метода проверки статус кода в ответе сервера
 */
@AllArgsConstructor //конструктор с ожидаемым статус кодом
public class StatusCodeCondition implements Condition {
    private int statusCodeExpected;

    /**
     * Проверка что ответ сервера имеет ожидаемый статус код
     * @param response ответ с сервера
     */
    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().statusCode(statusCodeExpected);
    }
}
