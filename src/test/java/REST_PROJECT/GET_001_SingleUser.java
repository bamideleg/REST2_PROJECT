//



package REST_PROJECT;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

@Test
    public class GET_001_SingleUser {

        public void test_GET_Single_User () {

            given().
                    get("https://reqres.in/api/users/2").
           then().statusCode(200).

//                    body("data.email[2]",equalTo("janet.weaver@reqres.in")).
                    body("data.email[2]",equalTo("n")).
           log().all();

        }


}
