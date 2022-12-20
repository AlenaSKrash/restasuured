package asserts;

import io.restassured.response.ValidatableResponse;

/**
 * Интерфейс для общей логики реализации проверки
 */
public interface Condition {
    void check(ValidatableResponse response);
}
