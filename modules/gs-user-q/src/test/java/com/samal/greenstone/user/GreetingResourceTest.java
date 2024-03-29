package com.samal.greenstone.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .log()
        .all()
        .when()
        .get("/hello")
        .then()
        .log()
        .all()
        .statusCode(200)
        .body(is("Hello RESTEasy"));
  }

  @Test
  public void testGreetingEndpoint() {
    String uuid = UUID.randomUUID().toString();
    given()
        .pathParam("name", uuid)
        .when()
        .get("/hello/greeting/{name}")
        .then()
        .statusCode(200)
        .body(is("hello " + uuid));
  }
}
