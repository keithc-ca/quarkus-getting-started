package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

	@Test
	public void testHelloEndpoint() {
		given() //
				.when().get("/hello") //
				.then() //
				.statusCode(200) //
				.body(is("hello"));
	}

	@Test
	public void testLogManager() {
		given() //
				.when().get("/hello/logmanager") //
				.then() //
				.statusCode(200) //
				.body(is("LogManager class is org.jboss.logmanager.LogManager"));
	}

}
