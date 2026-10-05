package ndosiapitest;

import api.requestbuilder.ProfileRequestBuilder;
import api.requestbuilder.UserRequestBuilder;
import config.ConfigReader;
import org.testng.annotations.Test;
import utils.DatabaseConnection;

import java.io.File;
import java.sql.SQLException;

import static org.hamcrest.Matchers.equalTo;
@Test
public class ProfileApiTest {

      String imagePath = ConfigReader.getProperty("imagepath");

//    @Test
//    public void fetchUserProfile() {
//        ProfileRequestBuilder.fetchUserProfile()
//                .then().log().all()
//                .assertThat()
//                .statusCode(200);
//    }
@Test
public void updateImage() throws SQLException {

    // Get existing profile image information from database
    DatabaseConnection.getUserImage(1);

    // This must be a REAL file on your test machine
    File image = new File(imagePath);

    ProfileRequestBuilder.updateProfileImage(
                    image,
                    DatabaseConnection.CurrentProfileImage,
                    DatabaseConnection.PreviousProfileImage,
                    true
            )
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200);
   }
}