package com.ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class ValidateXML_POST {


    @BeforeClass
    public void setup()
    {
        RestAssured.baseURI = "https://petstore.swagger.io";
    }

// To accept XML, we have to set the header, we can get the value in Swagger and c

    @Test
    public void postPet (){

              String json = "{\n" +
                      "  \"id\": 0,\n" +
                      "  \"category\": {\n" +
                      "    \"id\": 0,\n" +
                      "    \"name\": \"string\"\n" +
                      "  },\n" +
                      "  \"name\": \"doggie121\",\n" +
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

              Response response = given().header("accept"," application/xml").header("Content-Type"," application/xml").
                      when().post("/v2/pet");
               System.out.println(response.asPrettyString());
              Assert.assertEquals(response.statusCode(),400);
             Assert.assertEquals(response.contentType(), "application/xml");

    }

    @Test
    public void putPet (){

        String json = " '{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"SuperCat2\",\n" +
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

        given().header("accept"," application/xml").header("Content-Type"," application/xml").
                when().put("/v2/pet");


    }
    @Test
    public void patchPet () {

        String json = " '{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"SuperCat21\",\n" +
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

        given().header("accept", " application/xml").header("accept", " application/xml").
                when().patch("/v2/pet");
        System.out.println(json);
    }
}
