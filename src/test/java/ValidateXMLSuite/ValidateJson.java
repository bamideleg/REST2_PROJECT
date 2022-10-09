package ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateJson {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }


    @Test
    public void testAPI () {

        System.out.println("Test 123456 ");
        RestAssured.baseURI = "https://petstore.swagger.io";

        Response response = given().
                when().get("v2/pet/findByStatus?status=pending");
 //               then().statusCode().log().all();
//                 System.out.println(response.asString());
//                             or
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/json");

    }

  //  How to convert json file to xml
    @Test
    public void testAP2 () {

        System.out.println("Test 123456 ");
        RestAssured.baseURI = "https://petstore.swagger.io";

        Response response = given().header("accept", "application/xml").
                when().get("v2/pet/findByStatus?status=pending");

//                             or
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
//        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.contentType(), "application/xml");

    }
}
