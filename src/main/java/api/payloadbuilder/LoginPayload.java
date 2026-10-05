package api.payloadbuilder;

import org.json.simple.JSONObject;

public class LoginPayload {

    public static JSONObject userLoginPayload(String email, String password) {
        JSONObject userLogin = new JSONObject();
        userLogin.put("email", email);
        userLogin.put("password", password);

        return userLogin;
    }
}
