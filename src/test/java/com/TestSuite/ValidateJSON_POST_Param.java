// https://www.youtube.com/watch?v=Ls48Yi8-2Ew

// RestAssured | How to upload file using API
//https://www.youtube.com/watch?v=z2m-YX4gKlo

package com.TestSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ValidateJSON_POST_Param {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testAPI_GET_All_Users () {


        Response response = given().header("accept"," application/json").
                when().get("/api/users?page=2");

        System.out.println(response.asString());
//                            or,
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

    @Test
    public void testAPI_GET_Sngle_User () {


        Response response = given().header("accept"," application/json").
                when().get("/api/users/2");

                System.out.println(response.asString());
//                            or,
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

    @Test
    public void postPetsDataValidation(){

        long acctid;

              String json = "\"name\": \"morpheus\"," +
                      "    \"job\": \"leader\"";
              System.out.println(json);

           Response response = given().header("accept"," application/json").header("Content-Type", "application/json").body("json").
                      when().post("/api/users?page=2");
           System.out.println(json);


           System.out.println(response.asString());
            System.out.println(response.prettyPrint());
            Assert.assertEquals(response.statusCode(), 200);
            Assert.assertEquals(response.contentType(), "application/json");

        response.then().body("id", equalTo(0))
                .body("email", equalTo("george.bluth@reqres.in"))
                .body("name", equalTo("George"));
//                .body("tags[0].id", equalTo(0))




//        long petid = response.path("id");
           acctid = response.path("id");
           System.out.println("acctid");
    }

    @Test(dependsOnMethods = "postPetsDataValidation")
    public void putPets() {

        String json = " \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"";

        System.out.println(json);

        Response response = given().header("accept", " application/json").header("Content-Type", "application/json").body("json").
                when().put("/api/users");

        System.out.println(response.asString());
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }

    @Test (dependsOnMethods = "putPets")
    public void delete() {
        Response response = given().header("accept","application/json")
                .when().delete("v2/pet/petid");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }
    @Test (dependsOnMethods = "postPetsDataValidation")
    public void postUpdate(){
        Response response = given().header("accept","application/json").header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name","Cat").formParam("status", "Sold")
                .when().post("v2/pet/9223372036854776000");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }
}
