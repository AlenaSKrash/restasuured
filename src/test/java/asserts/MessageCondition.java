package asserts;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import pojos.Info;
/**
 * Реализация интерфейа Condition для универсального метода проверки сообщения в ответе сервера
 */
@AllArgsConstructor //конструктор с ожидаемым сообщением
public class MessageCondition implements Condition{
    private String expectedMessage;

    /**
     * Извлечение ответа в pojo класс с информацией и проверка что message является ожидаемым результатом
     * @param response ответ с сервера
     */
    @Override
    public void check(ValidatableResponse response) {
        Info info = response.extract().body().jsonPath().getObject("info", Info.class);
        Assertions.assertEquals(info.getMessage(), expectedMessage);
    }
}
