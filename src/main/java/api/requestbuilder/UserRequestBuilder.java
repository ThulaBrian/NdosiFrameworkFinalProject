package api.requestbuilder;

import api.payloadbuilder.LoginPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequestBuilder {

    static String userToken;

    public static Response loginUser(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = given()
                .baseUri("Baseurl")
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(LoginPayload.userLoginPayload(email, password))
                .post()
                .then()
                .extract().response();
        userToken = response.jsonPath().getString("data.token");
        return response;

    }
}
