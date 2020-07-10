import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RestaurantDailyMenuTest extends BaseTest{

    Map<String,String> headersMap= new HashMap<>();
    Map<String,String> queryParamMap= new HashMap<>();

    @Test
    public void restaurantDailyMenuTestPositiveFlow() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("res_id","16507624");

        Response res=getApi(ApiEndPoint.restaurantDailyMenu,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
    }

    @Test
    public void restaurantDailyMenuTestInvalidResId() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("res_id","0");

        Response res=getApi(ApiEndPoint.restaurantDailyMenu,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),400);
    }

    @Test
    public void restaurantDailyMenuTestEmptyResId() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("res_id","0");

        Response res=getApi(ApiEndPoint.restaurantDailyMenu,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),400);
    }

    @Test
    public void restaurantDailyMenuTestMissingResId() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");

        Response res=getApi(ApiEndPoint.restaurantDailyMenu,null,null,headersMap);
        Assert.assertEquals(res.statusCode(),400);
    }

}
