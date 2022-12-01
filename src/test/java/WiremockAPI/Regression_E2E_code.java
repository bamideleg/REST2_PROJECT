// API Automation Testing Advanced Concepts
//WireMock in 30min
// https://www.youtube.com/watch?v=iEDeiBPDFjs


package WiremockAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Regression_E2E_code {


    @Test
    public void TC01_GET_user1 () {

          given().
                  get("http://localhost:8080/api/users/1").

                  then().assertThat().
                  statusCode(200);

    }
    @Test
    public void TC02_GET_users2 () {

        String contentType = RestAssured.
        given().
                get("http://localhost:8080/api/users2").

                then().assertThat().
                statusCode(200).
                extract().
                header("Content-Type");

        System.out.println("testResponseHeaders:"+contentType);
        Assert.assertEquals("text/plain", contentType);


    }


    @Test
    public void TC02_GET_User3_testResponseHeaders () {
        String contentType = RestAssured.

        given().
                get("http://localhost:8080/api/users3").

                then().assertThat().
                statusCode(200).
                extract().
                 header("Content-Type");

        System.out.println("testResponseHeaders:"+contentType);
        Assert.assertEquals("text/plain", contentType);

    }
    @Test
    public void TC02_POST_User4 () {

        given().
                post("http://localhost:8080/api/users4").

                then().assertThat().
                statusCode(201);

    }
}


