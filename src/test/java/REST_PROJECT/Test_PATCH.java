package REST_PROJECT;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;



public class Test_PATCH {


    @Test
    public void test_POST1(){

        JSONObject request = new JSONObject();

        request.put("name", "Lord Nelson 123");
        request.put("Job", "Teacher");

        // Different way fo printing values
        System.out.println(request);
        System.out.println(request.toJSONString());


        given().
                header("content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).

                when().
                patch("https://reqres.in/api/users/8").
                then().statusCode(200).log().all();
    }


}
