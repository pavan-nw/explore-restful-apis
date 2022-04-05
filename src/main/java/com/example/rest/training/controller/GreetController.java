package com.example.rest.training.controller;

import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/greet")
public class GreetController {

    // URL: http://localhost:8080/api/greet/hello
    @GET
    @Path("/hello")
    public String greetWithGreeting() {
        System.out.println("I am greeting");
        return "Hello Guys & Gals";
    }

    // URL: http://localhost:8080/api/greet/hello/Virat
    @GET
    @Path("/hello/{name}/{age}")
    public String greetNameWithGreeting(@PathParam("name") String personName, @PathParam("age") String age) {
        System.out.println("I am greeting to " + personName);
        return "Hello " + personName + " with age " + age;
    }

    // URL: http://localhost:8080/api/greet?who=rohit&greeting=welcome
    @GET
    @Path("/")
    public String greetWithGreeting1(@QueryParam("greeting") String greet, @QueryParam("who") String name) {
        System.out.println("I am greeting "+ greet + " to " + name);
        return greet.toUpperCase() + " " + name.toUpperCase();
    }
}
