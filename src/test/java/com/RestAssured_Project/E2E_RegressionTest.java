



package com.RestAssured_Project;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


// E2E Regression Testing Pack
@Test
    public class E2E_RegressionTest {

        public void test_GET_1 () {

            given().
                    header("content-type", "application/xml").
                    get("https://reqres.in/api/users?page=2").

                    

                    then().statusCode(200).
//         To validate a specific response data, you need to specify the data and data position, see the response
//         Note: Java count starts at 0,1,2 etc

                    body("data.id[2]", equalTo(9)).
                    body("data.email[2]",equalTo("tobias.funke@reqres.in")).
     //   To check multiple field that has first_name, see the code below
                    body("data.first_name", hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel")).

 //                 Assert.assertEquals(StatusCode, 200);
           log().all();

//    Update GET API code


        }


}
