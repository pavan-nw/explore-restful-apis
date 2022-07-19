package com.example.rest.training.july2022.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/greet/")
public class GreetingController {

    // http://localhost:8080/july2022/greet/hello
    @GET
    @Path("hello")
    @Produces("text/plain")
    public String greetHello() {
        System.out.println("Greeting..");
        return "Hello World...";
    }

    // http://localhost:8080/july2022/greet/say/Rohit
    @GET
    @Path("say/{personName}/{city}")
    @Produces("text/plain")
    public String greetByName(@PathParam("city") String place, @PathParam("personName") String user) {
        System.out.println("Greeting by name..");
        return "Hello " + user + " from " + place;
    }
}
