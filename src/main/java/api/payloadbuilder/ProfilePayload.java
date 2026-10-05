package api.payloadbuilder;

import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProfilePayload {



    public static JSONObject fetchProfilePayload(
            String firstName,
            String lastName,
            String phone,
            String phoneNumber,
            String linkedIn,
            String githubUsername,
            String linkedInUrl,
            String linkedin,
            String yearsOfExperience) {

        JSONObject profile = new JSONObject();

        profile.put("firstName", firstName);
        profile.put("lastName", lastName);
        profile.put("phone", phone);
        profile.put("phoneNumber", phoneNumber);
        profile.put("linkedIn", linkedIn);
        profile.put("githubUsername", githubUsername);
        profile.put("linkedInUrl", linkedInUrl);
        profile.put("linkedin", linkedin);
        profile.put("yearsOfExperience", yearsOfExperience);

        return profile;
    }
    public static JSONObject profilePicturePayload(String profileImage) {
        JSONObject userprofilePayload = new JSONObject();
        userprofilePayload.put("profileImage", profileImage);
        return userprofilePayload;
    }
    public static RequestSpecification updateImage(
            File profileImage,
            String currentProfileImage,
            String previousProfileImage,
            boolean replaceExisting) {

        return given()
                .multiPart("profileImage", profileImage, "image/jpeg")
                .multiPart("currentProfileImage", currentProfileImage)
                .multiPart("previousProfileImage", previousProfileImage)
                .multiPart("replaceExisting", String.valueOf(replaceExisting));
    }

}



