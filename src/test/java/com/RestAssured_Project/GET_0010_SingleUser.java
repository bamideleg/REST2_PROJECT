//



package com.RestAssured_Project;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Test
    public class GET_0010_SingleUser {


        public void TC01_GET_Single_User () {

            // Executing API collection from POSTMAN

            given().
                    get("https://www.getpostman.com/collections/841309fb730ce28b0d75").
           then().statusCode(200).log().all().

                    body("data.id[2]", equalTo(9)).
                    body("data.email[2]",equalTo("tobias.funke@reqres.in")).
           log().all();

        }

    @Test
    public void TC02_testAPI () {

//        RestAssured.baseURI = "https://petstore.swagger.io";

// To accept XML, we have to set the header, we can get the value in Swagger and POSTMAN

        System.out.println("TC01_testAPI smoke test is starting");

        Response response = given().header("accept"," application/xml").
                when().get("https://www.getpostman.com/collections/841309fb730ce28b0d75");

                 System.out.println(response.asString());
//                             or,
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
//        Assert.assertEquals(response.contentType(), "application/xml; charset=utf-8");
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        System.out.println("Passed");
        System.out.println("TC01_testAPI smoke test is completed");
    }
}

