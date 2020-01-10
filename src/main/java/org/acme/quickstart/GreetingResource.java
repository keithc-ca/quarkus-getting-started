package org.acme.quickstart;

import java.util.logging.LogManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/hello")
public class GreetingResource {

	@Inject
	GreetingService service;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/greeting/{name}")
	public String greeting(@PathParam String name) {
		return service.greeting(name);
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/logmanager")
	public String logmanager() {
		LogManager lm = LogManager.getLogManager();

		return "LogManager class is " + lm.getClass().getName();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/version")
	public String version() {
		String version = System.getProperty("java.version", "(unknown)");

		return "Java version is " + version;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/fullversion")
	public String fullversion() {
		String version = System.getProperty("java.fullversion", "(unknown)");

		return "Java version is " + version;
	}

}
