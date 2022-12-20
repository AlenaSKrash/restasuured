package services;

import asserts.AssertableResponse;
import pojos.ChangePassword;
import pojos.UserRegister;

import java.util.HashMap;
import java.util.Map;

import static asserts.Conditions.hasKey;
import static asserts.Conditions.hasStatusCode;

public class UserService extends WebService {

    public UserService() {
        super("");
    }

    /**
     * Регистрируем нового пользователя
     * @param userRegister новый пользователь
     * @return
     */
    public AssertableResponse register(UserRegister userRegister) {
        return new AssertableResponse(requestSpec.body(userRegister).post("/register").then());
    }

    /**
     * Получаем информацию о пользователе
     * @return
     */
    public AssertableResponse getUserInfo() {
        return new AssertableResponse(requestSpec.auth().oauth2(jwt).get("/user").then());
    }

    /**
     * Обновляем пароль у пользователя
     * @param newPass новый пароль
     * @return
     */
    public AssertableResponse updatePassword(ChangePassword newPass){
        return new AssertableResponse(requestSpec.auth().oauth2(jwt).body(newPass).put("/user").then());
    }

    /**
     * Авторизация пользователя и получение jwt токена для дальнешего вызова методов
     * @param userRegister пользователь под которым нужно авторизоваться
     */
    public void authUser(UserRegister userRegister) {
        Map<String, String> user = new HashMap<>();
        user.put("password", userRegister.getPass());
        user.put("username", userRegister.getLogin());

        jwt = new AssertableResponse(requestSpec.body(user).post("/login").then())
                .should(hasStatusCode(200)) //проверяем что ответ правильный
                .should(hasKey("token")) //проверяем что ключ token пришел и нет ошибки
                .as("token", String.class); //извлекаем значение ключа token в виде класса String
    }
}
