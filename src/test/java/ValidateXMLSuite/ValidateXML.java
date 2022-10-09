package ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateXML {


    @Test
    public void testAPI () {

        System.out.println("Test 123456 ");
        RestAssured.baseURI = "https://petstore.swagger.io";

// To accept XML, we have to set the header, we can get the value in Swagger and ca

        Response response = given().header("accept"," application/xml").
                when().get("v2/pet/findByStatus?status=pending");
 //               then().statusCode().log().all();
//                 System.out.println(response.asString());
//                             or,
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/xml");







    }
}
