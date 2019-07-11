package api.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by intel on 7/8/2019.
 */
public class ApiResponse {
    String ApiCode;
    String message;
    Map<String, String> map;

    public ApiResponse(String apiCode, String message) {
        ApiCode = apiCode;
        this.message = message;
        this.map = new HashMap<>();
    }


    public String getApiCode() {
        return ApiCode;
    }

    public void setApiCode(String apiCode) {
        ApiCode = apiCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
