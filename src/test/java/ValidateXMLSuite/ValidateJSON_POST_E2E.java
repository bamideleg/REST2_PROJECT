package ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ValidateJSON_POST_E2E {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

    @Test
    public void testAPI_GET1 () {


// RestAssured.baseURI = "https://petstore.swagger.io";
// To accept XML, we have to set the header, we can get the value in Swagger and ca

        Response response = given().header("accept"," application/json").
                when().get("v2/pet/findByStatus?status=available");
//                when().get("v2/pet/9223372036854036000");

                System.out.println(response.asString());
//                            or,
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/json");

    }

    @Test
    public void postPets(){

        long petid;

        String json = "{\n" +
                      "  \"id\": 0,\n" +
                      "  \"category\": {\n" +
                      "    \"id\": 0,\n" +
                      "    \"name\": \"string\"\n" +
                      "  },\n" +
                      "  \"name\": \"doggie01\",\n" +
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
                      "}";
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

    @Test
    public void testAPI_GET2 () {


// RestAssured.baseURI = "https://petstore.swagger.io";
// To accept XML, we have to set the header, we can get the value in Swagger and ca

        Response response = given().header("accept"," application/json").
                when().get("v2/pet/9223372036854036000");

        System.out.println(response.asString());
//                            or,
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }


    @Test
    public void putPets(){

         String json = "'{\n" +
                 "  \"id\": 9223372036854036000,\n" +
                 "  \"category\": {\n" +
                 "    \"id\": 0,\n" +
                 "    \"name\": \"string\"\n" +
                 "  },\n" +
                 "  \"name\": \"doggie20\",\n" +
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

        Response response = given().header("accept"," application/json").header("Content-Type", "application/json").body("json").
                when().put("/v2/pet");

        System.out.println(response.asString());
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }
    @Test
    public void patchPets(){

        String json = "'{\n" +
                "  \"id\": 9223372036854776000,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie2\",\n" +
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

        Response response = given().header("accept"," application/json").header("Content-Type", "application/json").body("json").
                when().patch("/v2/pet");

        System.out.println(response.asString());
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");

    }

    @Test
    public void delete() {
        Response response = given().header("accept","application/json")
                .when().delete("v2/pet/9223372036854035000");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json");


    }

    @Test
    public void postUpdate(){
        Response response = given().header("accept","application/json").header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name","Cat").formParam("status", "Sold")
                .when().post("v2/pet/9223372036854776000");

                 System.out.println(response.asPrettyString());
                 Assert.assertEquals(response.statusCode(), 200);
                 Assert.assertEquals(response.contentType(), "application/json");

    }
}
