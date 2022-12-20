package asserts;

/**
 * Класс с статичными методами для вызова их в тестах
 */
public class Conditions {
    /**
     * Проверяет статус код на ответе сервера
     * @param code ожидаемый статус код
     * @return экземпляр класса с проверкой статус кода
     */
    public static StatusCodeCondition hasStatusCode(int code){
        return new StatusCodeCondition(code);
    }

    /**
     * Проверяет ожидаемое сообщение в ответе сервера
     * @param expectedMessage ожидаемое сообщение
     * @return экземпляр класса с проверкой сообщения
     */
    public static MessageCondition hasMessage(String expectedMessage){
        return new MessageCondition(expectedMessage);
    }

    /**
     * Проверяет существует ли ключ в ответе сервера
     * @param key ожидаемый ключ
     * @return экземпляр класса с проверкой ключа
     */
    public static KeyNotNullCondition hasKey(String key){
        return new KeyNotNullCondition(key);
    }
}
