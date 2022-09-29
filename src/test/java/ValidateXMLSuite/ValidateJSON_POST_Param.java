// https://www.youtube.com/watch?v=Ls48Yi8-2Ew

// RestAssured | How to upload file using API
//https://www.youtube.com/watch?v=z2m-YX4gKlo

package ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;



public class ValidateJSON_POST_Param {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void testAPI_GET1 () {


        Response response = given().header("accept"," application/json").
                when().get("v2/pet/9223372036854776000");

                System.out.println(response.asString());
//                            or,
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/json");

    }

    @Test
    public void postPetsDataValidation(){

        long petid;

              String json = "{" +
                      "  \"id\": ," +
                      "  \"category\": {" +
                      "    \"id\": 0," +
                      "    \"name\": \"petCat1\"" +
                      "  }," +
                      "  \"name\": \"Cat\"," +
                      "  \"photoUrls\": [" +
                      "    \"string\"" +
                      "  ]," +
                      "  \"tags\": [" +
                      "    {" +
                      "      \"id\": 0," +
                      "      \"name\": \"tag1\"" +
                      "    }" +
                      "  ]," +
                      "  \"status\": \"available\"" +
                      "}'";
//              System.out.println(json);

           Response response = given().header("accept"," application/json").header("Content-Type", "application/json").body("json").
                      when().post("/v2/pet");
           System.out.println(json);


           System.out.println(response.asString());
            System.out.println(response.prettyPrint());
            Assert.assertEquals(response.statusCode(), 200);
            Assert.assertEquals(response.contentType(), "application/json");

        response.then().body("category.id", equalTo(0))
                .body("category.name", equalTo("PetCat"))
                .body("name", equalTo("Cat"))
                .body("tags[0].id", equalTo(0))
                .body("tags[0].name", equalTo("tag1"))
                .body("status", equalTo("available"));


//        long petid = response.path("id");
           petid = response.path("id");
           System.out.println("petid");
    }

    @Test(dependsOnMethods = "postPetsDataValidation")
    public void putPets() {

        String json = "'{\n" +
                "  \"id\": +petid+,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"petCat2\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}'";

        System.out.println(json);

        Response response = given().header("accept", " application/json").header("Content-Type", "application/json").body("json").
                when().put("/v2/pet");

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
