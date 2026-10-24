package api.payloadbuilder;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPayload {

    public static JSONObject userLoginPayload(String email, String password) {
        JSONObject userLogin = new JSONObject();
        userLogin.put("email", email);
        userLogin.put("password", password);

        return userLogin;
    }
//      public static Map<String, Object> build(String email, String password) {
//      Map<String, Object> payload = new HashMap<>();
//      payload.put("email", email);
//      payload.put("password", password);
//      return payload;
//  }
}

