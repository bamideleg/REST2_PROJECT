
package REST_PROJECT;

import io.restassured.http.ContentType;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class Test_POST {

    @Test
    public void test_POST1(){

 //Map is created to store the data


        // Option 1
        //Map<String, Object> map = new HashMap<String, Object>();
       // map.put("name", "Lord Nelson");
       // map.put("Job", "Teacher");
       // System.out.println(map);

        // Option 2 , we can comment the map out by directly using JSONOBJECT. The above lines of code
        // can be commented.
        JSONObject request = new JSONObject();

        request.put("name", "Lord Nelson");
        request.put("Job", "Teacher");

       // Different way fo printing values
        System.out.println(request);
        System.out.println(request.toJSONString());


        given().
                // It is a good practice to have header
                header("content-type", "application/json").
                // We can also accept the content type as Json
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().statusCode(201).log().all();
    }


}
