import io.restassured.response.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest {
    Map<String, String> emptyHashMap = new HashMap<>();

    protected Response getApi(String url, Map<String,String> queryParamMap, Map<String,String> pathParamMap,Map<String,String> headersMap ) throws Exception{
        if(queryParamMap==null) queryParamMap=emptyHashMap;
        if(pathParamMap==null) pathParamMap=emptyHashMap;
        if(headersMap==null) headersMap=emptyHashMap;
        Response res=given().queryParams(queryParamMap).params(pathParamMap).headers(headersMap).log().all().
                get(url);
        res.then().log().all();
        return res;
    }

    protected Response postApi(String url, Map<String,String> queryParamMap, Map<String,String> pathParamMap,Map<String,String> headersMap, Object object) throws Exception{
        return given().queryParams(queryParamMap).params(pathParamMap).headers(headersMap).body(object).
                post(url);
    }

    protected Response putApi(String url, Map<String,String> queryParamMap, Map<String,String> pathParamMap,Map<String,String> headersMap, Object object ) throws Exception{
        return given().queryParams(queryParamMap).params(pathParamMap).headers(headersMap).body(object).
                put(url);
    }

}
