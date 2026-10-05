package ndosiapitest;

import org.testng.annotations.Test;
import api.requestbuilder.UserRequestBuilder;
import static org.hamcrest.Matchers.equalTo;

import utils.DatabaseConnection;

public class LoginApiTest {

    @Test
    public void userLoginTest() {

                UserRequestBuilder.loginUser(DatabaseConnection.getEmail, DatabaseConnection.getPassword)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }
}
