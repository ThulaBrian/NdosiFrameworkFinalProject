package api.requestbuilder;

import api.payloadbuilder.LoginPayload;
import api.payloadbuilder.ProfilePayload;
import config.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProfileRequestBuilder {
    static String userToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJlNWQ3M2FmMy03MmJkLTQ0N2ItYWRlYS1mYTI2OWM4ZWU2NzgiLCJlbWFpbCI6IkJyaWFuMTBXYW5kYUBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsInNlc3Npb25JZCI6IjE5ZWJlZDBlLTk2NTEtNGNjYy04ZGQzLTQwNDYwMDYyZDUzMiIsImlhdCI6MTc5MTAzODY3MSwiZXhwIjoxNzkxMTI1MDcxfQ.ur_aCDZx0tUzkAX3yQ1lT8fZiYQa4Blw1ofs0x1xqqY";
    static String BaseURL = ConfigReader.getProperty("Baseurl");


    public static Response fetchProfile(
            String firstName,
            String lastName,
            String phone,
            String phoneNumber,
            String linkedIn,
            String githubUsername,
            String linkedInUrl,
            String linkedin,
            String yearsOfExperience
    )
    {
        String apiPath = "/APIDEV/profile";
        Response response = given()
                .baseUri(BaseURL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(ProfilePayload.fetchProfilePayload(firstName,
                         lastName,
                         phone,
                         phoneNumber,
                         linkedIn,
                         githubUsername,
                         linkedInUrl,
                         linkedin,
                         yearsOfExperience))
                .header("Authorization", "Bearer " + UserRequestBuilder.userToken)
                .put()
                .then()
                .extract().response();
        return response;
    }

//    public static Response updateProfile(String profileImage)
//    {
//        String apiPath = "/APIDEV/profile/image";
//        Response response = given()
//                .baseUri(BaseURL)
//                .basePath(apiPath)
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .body(ProfilePayload.profilePicturePayload(profileImage))
//                .header("Authorization", "Bearer " + UserRequestBuilder.userToken)
//                .post()
//                .then()
//                .extract().response();
//        return response;
//    }
    public static Response fetchUserProfile()
    {
        String apiPath ="/APIDEV/profile";

        Response response = given()
                .baseUri(BaseURL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + userToken)
                .get()
                .then().extract().response();
        return response;

    }
    public static Response updateProfileImage(
            File profileImage,
            String currentProfileImage,
            String previousProfileImage,
            boolean replaceExisting) {

        String apiPath = "/APIDEV/profile/image";

        Response response = ProfilePayload.updateImage(
                        profileImage,
                        currentProfileImage,
                        previousProfileImage,
                        replaceExisting)
                .baseUri(BaseURL)
                .basePath(apiPath)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + userToken)
                .when()
                .post()
                .then()
                .extract()
                .response();

        return response;
    }

}
