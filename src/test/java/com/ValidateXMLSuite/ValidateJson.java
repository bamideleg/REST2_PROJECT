package com.ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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


        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
//        Assert.assertEquals(response.contentType(), "application/json");
        Assert.assertEquals(response.contentType(), "application/xml");

        response.then().body("category.id", equalTo(107))
                .body("category.name", equalTo("PetCat"))
                .body("name", equalTo("Cat"))
                .body("tags[0].id", equalTo(0))
                .body("tags[0].name", equalTo("tag1"))
                .body("status", equalTo("available"));

    }
}
