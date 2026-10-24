package ndosiapitest;

import api.requestbuilder.ProfileRequestBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import api.requestbuilder.UserRequestBuilder;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.hamcrest.Matchers.equalTo;
import utils.ReadFromExcelFile;
import java.io.IOException;

public class ProfileApiTests {

    @Test(priority = 1)
    @Story("API Tests(Rest Assured Tests)")
    @Severity(CRITICAL)
    @Description("User login test")
    public void userLoginTest() {

        UserRequestBuilder.loginUser(ReadFromExcelFile.email, ReadFromExcelFile.password)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 2, dependsOnMethods = "userLoginTest")
    @Story("API Tests(Rest Assured Tests)")
    @Severity(CRITICAL)
    @Description("Fetch User Profile")
    public void fetchUserProfile() {
        ProfileRequestBuilder.fetchUserProfile()
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("message", equalTo("Profile retrieved successfully"));

    }

    @Test(priority = 3, dependsOnMethods = "userLoginTest")
    @Story("API Tests(Rest Assured Tests)")
    @Severity(CRITICAL)
    @Description("Update profile picture")
    public void updateProfileWithBase64Avatar() throws IOException {
        ProfileRequestBuilder.updateProfileWithBase64(
                        "FirstName", "LastName", "Automation engineer testing profile update")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Test(priority = 4, dependsOnMethods = "userLoginTest")
    @Story("API Tests(Rest Assured Tests)")
    @Severity(CRITICAL)
    @Description("Uploading the profile picture")
    public void uploadProfilePicture() {
        ProfileRequestBuilder.uploadProfilePicture()
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

}
