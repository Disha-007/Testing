import Locations.LocationsResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LocationsTest extends BaseTest{

    Map<String,String> headersMap= new HashMap<>();
    Map<String,String> queryParamMap= new HashMap<>();


    @Test
    public void locationsPositiveFlow() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");
        queryParamMap.put("lat","28");
        queryParamMap.put("lon","77");
        queryParamMap.put("count","10");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
        Assert.assertEquals(String.valueOf(response.locationSuggestions.size()), queryParamMap.get("count"));
        // Ideally the lat and long should also be filtered
    }

    @Test
    public void locationsOnlyMandatoryParam() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsSpecialCharacterForQuery() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","@@@");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsNumericValueForQuery() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","11");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getTitle().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsAlphaNumericValueForQuery() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","S11");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getTitle().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsNegativeCount() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");
        queryParamMap.put("count","-10");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);// Ideally should be 400
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsZeroCount() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");
        queryParamMap.put("count","0");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);// Ideally should be 400
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsAlphanumericCount() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");
        queryParamMap.put("count","a10");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);// Ideally should be 400
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

    @Test
    public void locationsAlphanumericLatAndLon() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        queryParamMap.put("query","del");
        queryParamMap.put("lat","28a");
        queryParamMap.put("lon","77a");
        queryParamMap.put("count","10");

        Response res=getApi(ApiEndPoint.locations,queryParamMap,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);// Ideally should be 400
        LocationsResponse response= res.as(LocationsResponse.class);
        for(int i=0;i<response.locationSuggestions.size();i++)
        {
            Assert.assertTrue(response.getLocationSuggestions().get(i).getCityName().toLowerCase().contains(queryParamMap.get("query")));
        }
    }

}
