import CommonCategories.CommonCategoriesResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommonCategoriesTest extends BaseTest{


    Map<String,String> headersMap= new HashMap<>();

    public List<String> populateCategoriesList() throws Exception{
        List<String> categories = new ArrayList<>();
        categories.add("Delivery");
        categories.add("Dine-out");
        categories.add("Nightlife");
        categories.add("Catching-up");
        categories.add("Takeaway");
        categories.add("Cafes");
        categories.add("Daily Menus");
        categories.add("Breakfast");
        categories.add("Lunch");
        categories.add("Dinner");
        categories.add("Pubs & Bars");
        categories.add("Pocket Friendly Delivery");
        categories.add("Clubs & Lounges");
        return categories;
    }


    @Test
    public void commonCategoriesPositiveFlow() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb1329");
        Response res=getApi(ApiEndPoint.commonCategories,null,null,headersMap);
        Assert.assertEquals(res.statusCode(),200);
        CommonCategoriesResponse response= res.as(CommonCategoriesResponse.class);
        List<String> categories= populateCategoriesList();
        Assert.assertEquals(response.getCategories().size(),categories.size());
        List<String> categoriesInResponse= new ArrayList<>();
        for(int i=0;i<categories.size();i++)
        {
            categoriesInResponse.add(response.getCategories().get(i).getCategories().getName());
        }
        Assert.assertTrue(categoriesInResponse.containsAll(categories));

    }

    @Test
    public void commonCategoriesInvalidUserKey() throws Exception
    {
        headersMap.put("user-key","150bccf8e59e4fa3f3df3edc77bb13291");
        Response res=getApi(ApiEndPoint.commonCategories,null,null,headersMap);
        Assert.assertEquals(res.statusCode(),403);
    }

    @Test
    public void commonCategoriesMissingUserKey() throws Exception
    {
        Response res=getApi(ApiEndPoint.commonCategories,null,null,headersMap);
        Assert.assertEquals(res.statusCode(),403);
    }

    @Test
    public void commonCategoriesEmptyUserKey() throws Exception
    {
        headersMap.put("user-key","");
        Response res=getApi(ApiEndPoint.commonCategories,null,null,headersMap);
        Assert.assertEquals(res.statusCode(),403);
    }

}
