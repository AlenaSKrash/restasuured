package services;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class WebService {
    protected RequestSpecification requestSpec;
    protected String jwt;
    private String basePath;

    public WebService(String basePath){
        this.basePath = basePath;
        setSpec();
    }

    public void restSpec(){
        this.requestSpec = null;
        setSpec();
    }

    public void setSpec(){
        this.requestSpec = RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new ResponseLoggingFilter())
                .basePath(basePath);
    }
}
