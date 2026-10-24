package api.requestbuilder;

import api.payloadbuilder.LoginPayload;
import api.payloadbuilder.ProfilePayload;
import config.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import static io.restassured.RestAssured.given;

public class ProfileRequestBuilder {
    private static final String IMAGE_PATH = "src/main/resources/images/newimage.jpg";
    static String BaseURL = ConfigReader.getProperty("Baseurl");


    public static Response fetchUserProfile()
    {
        String apiPath ="/APIDEV/profile";

        Response response = given()
                .baseUri(BaseURL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + UserRequestBuilder.getToken())
                .get()
                .then().extract().response();
        return response;

    }
    public static Response updateProfileWithBase64(String firstName, String lastName,
                                                   String aboutMe) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(IMAGE_PATH));
        String base64Image = "data:image/jpeg;base64,"
                + Base64.getEncoder().encodeToString(bytes);
        String apiPath = "/APIDEV";
        return given()
                .baseUri(BaseURL)
                .basePath(apiPath)
                .header("Authorization", "Bearer " + UserRequestBuilder.getToken())
                .contentType(ContentType.JSON)
                .body(ProfilePayload.fetchProfilePayload(firstName, lastName, base64Image, aboutMe))
                .when()
                .put("/profile");
    }

    public static Response uploadProfilePicture() {
        File image = new File(IMAGE_PATH);
        String apiPath = "/APIDEV";
        return given()
                .baseUri(BaseURL)
                .basePath(apiPath)
                .header("Authorization", "Bearer " + UserRequestBuilder.getToken())
                .multiPart("profileImage", image, "image/jpeg")
                .when()
                .post("/profile/image");
    }

//    public static Response updateProfileImage(
//            File profileImage,
//            String currentProfileImage,
//            String previousProfileImage,
//            boolean replaceExisting) {
//
//        String apiPath = "/APIDEV/profile/image";
//
//        Response response = ProfilePayload.updateImage(
//                        profileImage,
//                        currentProfileImage,
//                        previousProfileImage,
//                        replaceExisting)
//                .baseUri(BaseURL)
//                .basePath(apiPath)
//                .accept(ContentType.JSON)
//                .header("Authorization", "Bearer " + userToken)
//                .when()
//                .post()
//                .then()
//                .extract()
//                .response();
//
//        return response;
//    }

}
