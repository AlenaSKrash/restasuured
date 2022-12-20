package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import services.UserService;

public class BaseTest {
    protected static UserService userService;
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://85.192.34.140:8080/api";
        userService = new UserService();
    }
}
