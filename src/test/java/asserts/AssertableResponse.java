package asserts;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;

/**
 * Класс для обертки ответа с сервера и выполнение промежуточных действий
 */
@RequiredArgsConstructor //создает конструктор, где в аргумент помещаются финальные переменные
public class AssertableResponse {
    private final ValidatableResponse response;

    /**
     * Проверка условия
     * @param condition реализация интерфейса Condition
     * @return текущий класс для дальнейших действий
     */
    public AssertableResponse should(Condition condition){
        condition.check(response);
        return this;
    }

    /**
     * Извлечение полного ответа сервера в определенный класс
     * @param tClass тип класса для извлечения
     * @return экземпляр извлеченного ответа в класс
     * @param <T> тип объекта
     */
    public <T> T as(Class<T> tClass){
        return response.extract().body().as(tClass);
    }

    /**
     * Извлечение какой то части из ответа сервера в определенный класс
     * @param tClass тип класса для извлечения
     * @return экземпляр извлеченного ответа в класс
     * @param <T> тип объекта
     */
    public <T> T as(String jsonPath, Class<T> tClass){
        return response.extract().body().jsonPath().getObject(jsonPath, tClass);
    }

    /**
     * Извлечь ответ в виде стандартного Response
     * @return экземпляр response
     */
    public Response asResponse(){
        return response.extract().response();
    }
}
