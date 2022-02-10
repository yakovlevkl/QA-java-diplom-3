package site.nomoreparties.stellarburgers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

class BaseUrls {

    static String getSiteUrl() {
        return "https://stellarburgers.nomoreparties.site";
    }

    static String getAuthUserUrl() {
        return "/api/auth/user";
    }

    static String getAuthRegisterUrl() {
        return "/api/auth/register";
    }

    static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(getSiteUrl())
                .build();
    }

}
