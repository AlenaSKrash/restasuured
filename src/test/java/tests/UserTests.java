package tests;

import asserts.Conditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojos.ChangePassword;
import pojos.UserRegister;

import java.util.Random;

import static asserts.Conditions.hasMessage;
import static asserts.Conditions.hasStatusCode;

public class UserTests extends BaseTest {

    private UserRegister randomUser;

    /**
     * Для каждого теста генерируем рандомного пользователя
     */
    @BeforeEach
    public void generateUser() {
        Random random = new Random();
        randomUser = new UserRegister("randomUser" + random.nextInt(), "randomPass" + random.nextInt());
    }

    @Test
    public void changePasswordAdminNegative(){
        userService.authUser(new UserRegister("admin", "admin"));
        ChangePassword changePassword = new ChangePassword("newPassowrd");
        userService.updatePassword(changePassword)
                .should(hasStatusCode(400))
                .should(hasMessage("Cant update base users"));
    }

    @Test
    public void changePasswordUserTestSuccess(){
        userService.register(randomUser);
        userService.authUser(randomUser);

        ChangePassword changePassword = new ChangePassword("newPassowrd");

        userService.updatePassword(changePassword)
                .should(hasStatusCode(200))
                .should(hasMessage("User password successfully changed"));

        UserRegister after = userService.getUserInfo().as(UserRegister.class);

        Assertions.assertNotEquals(randomUser.getPass(), after.getPass());
    }

    @Test
    public void successRegisterTest() {
        UserRegister userRegister = userService.register(randomUser)
                .should(hasStatusCode(201))
                .should(hasMessage("User created"))
                .as("register_data", UserRegister.class);

        Assertions.assertTrue(userRegister.getId().toString().matches("\\d+"));
    }

    @Test
    public void successAuth(){
        userService.register(randomUser);
        userService.authUser(randomUser);
        userService.getUserInfo()
                .should(Conditions.hasStatusCode(200))
                .should(Conditions.hasKey("id"));
    }

    @Test
    public void negativeRegisterTestUserLoginAlreadyExist() {
        UserRegister userRegister = new UserRegister("admin", "123");
        userService.register(userRegister)
                .should(hasStatusCode(400))
                .should(hasMessage("Login already exist"));
    }
}
