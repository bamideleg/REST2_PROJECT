package ValidateXMLSuite;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ValidateJSON_POST_ParamRgres {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }


    @Test
    public void testAPI_GETAllUsers () {


        Response response = given().header("accept"," application/json").
                when().get("/api/users?page=7");

                System.out.println(response.asString());
//                            or,
                  System.out.println(response.prettyPrint());
                   Assert.assertEquals(response.statusCode(), 200);
                   Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }

    @Test
    public void testAPI_GETSingleUser () {


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

              String json = "{\n" +
                      "    \"name\": \"morpheus\",\n" +
                      "    \"job\": \"leader\"\n" +
                      "}";
//              System.out.println(json);

           Response response = given().header("accept"," application/json").header("Content-Type", "application/json; charset=utf-8").body("json").
                      when().post("/api/users");
           System.out.println(json);


           System.out.println(response.asString());
            System.out.println(response.prettyPrint());
            Assert.assertEquals(response.statusCode(), 200);
            Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        response.then().body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"));

    }
}
