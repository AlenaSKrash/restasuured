package asserts;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.notNullValue;

/**
 * Реализация интерфейа Condition для универсального метода проверки ключа в ответе сервера
 */
@AllArgsConstructor //конструктор с ожидаемым ключом
public class KeyNotNullCondition implements Condition {
    private String keyName;

    /**
     * Проверка что ключ является не null в ответе сервера
     * @param response ответ с сервера
     */
    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().body(keyName, notNullValue());
    }

}
