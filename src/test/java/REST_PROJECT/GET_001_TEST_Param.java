package REST_PROJECT;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GET_001_TEST_Param {

        @Test
        public void test_GET_1 () {

            given().

                    // Data validation point
                    param("email", "tobias.funke@reqres.in").
                    get("https://reqres.in/api/https://reqres.inusers?page=2").
                    then().statusCode(200).
//
                     body("data.id[2]", equalTo(9)).
                     body("data.email[2]", equalTo("tobias.funke@reqres.in")).
                    //   To check multiple field that has first_name, see the code below
                            body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel")).

//                  Assert.assertEquals(StatusCode, 200);
        log().all();

            }

}
