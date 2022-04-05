package com.example.rest.training.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/shape")
public class ShapeController {

    // http://localhost:8080/api/shape/circle/10
    @GET
    @Path("/circle/{rad}")
    public Double computeAreaOfCircle(@PathParam("rad") Double radius) {
        System.out.println("Area is being computed for circle with radius " + radius);
        return 3.142 * radius * radius;
    }

    // http://localhost:8080/api/shape/square/10?displayStr=Area is being computed for sqaure with side
    @GET
    @Path("/square/{side}")
    public Double computeAreaOfSquare(@PathParam("side") Double side, @QueryParam("displayStr") String displayStr) {
        System.out.println(displayStr + side);
        return side * side;
    }
}
